package com.uttec.icae.controller.inventarios;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uttec.icae.model.Empleado;
import com.uttec.icae.model.Empresa;
import com.uttec.icae.model.Producto;
import com.uttec.icae.service.empleado.EmpleadoService;
import com.uttec.icae.service.producto.ProductoService;

@Controller
@SessionAttributes({ "usuario" })
public class InventariosController {

	private static final Logger logger = LoggerFactory
			.getLogger(InventariosController.class);

	@Autowired
	private ProductoService productoService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/inventarios/productos")
	public String listProductos(ModelMap model) {
		logger.debug("Recuperando productos");
		model.put("productos", productoService.findAll());
		return "/inventarios/listProductos";
	}
		
	@RequestMapping("/inventarios/newProducto")
	public String newProducto (ModelMap model) {
		logger.debug("Alta de nuevo producto");
		model.put("producto", new Producto());
		return "/inventarios/productosForm";
	}
	
	@RequestMapping("/inventarios/modifyProducto/{id}")
	public String modifyEmployee(ModelMap model, @PathVariable("id") Long id) {
		Producto producto = new Producto(id);
		producto = productoService.findOne(producto);
		model.put("producto", producto);
		return "/inventarios/productosForm";
	}
	
	
	@RequestMapping(value = {"/inventarios/saveProducto"}, method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Producto producto, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		if (producto.getId() != null) {
			productoService.update(producto);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.update", null, null));
		} else {
			productoService.save(producto);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.save", null, null));
		}
		return "redirect:/inventarios/productos";
	}
}

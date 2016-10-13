package com.uttec.icae.controller.facturacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uttec.icae.model.Cliente;
import com.uttec.icae.service.cliente.ClienteService;

@Controller
@SessionAttributes({ "usuario" })
public class FacturacionController {
	
	private static final Logger logger = LoggerFactory.getLogger(FacturacionController.class);
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/facturacion/clientes")
	public String listProductos(ModelMap model) {
		logger.debug("Recuperando clientes");
		model.put("clientes", clienteService.findAll());
		return "/facturacion/listClientes";
	}
		
	@RequestMapping("/facturacion/newCliente")
	public String newProducto (ModelMap model) {
		logger.debug("Alta de nuevo cliente");
		model.put("cliente", new Cliente());
		return "/facturacion/clientesForm";
	}
	
	@RequestMapping("/facturacion/modifyCliente/{id}")
	public String modifyEmployee(ModelMap model, @PathVariable("id") Long id) {
		Cliente cliente = new Cliente(id);
		cliente = clienteService.findOne(cliente);
		model.put("cliente", cliente);
		return "/facturacion/clientesForm";
	}
	
	
	@RequestMapping(value = {"/facturacion/saveCliente"}, method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute Cliente cliente, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		if (cliente.getId() != null) {
			clienteService.update(cliente);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.update", null, null));
		} else {
			clienteService.save(cliente);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.save", null, null));
		}
		return "redirect:/facturacion/clientes";
	}

}

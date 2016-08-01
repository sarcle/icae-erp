package com.uttec.icae.controller.inventarios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uttec.icae.model.Empleado;
import com.uttec.icae.service.empleado.EmpleadoService;

@Controller
@SessionAttributes({ "usuario" })
public class InventariosController {

	private static final Logger logger = LoggerFactory
			.getLogger(InventariosController.class);

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private MessageSource messageSource;

//	@RequestMapping("/inventarios/productosForm")
//	public String changePasswordForm(@ModelAttribute Usuario usuario, ModelMap model) {
//		model.put("usuarioForm", usuario);
//		return "";
//  }
		
	@RequestMapping("/inventarios/productosForm")
	public String listEmployees(ModelMap model) {
		logger.debug("se fue a buscar la ventana de productos");
		model.put("empleado", new Empleado());
		return "/inventarios/productosForm";
	}
	
	@RequestMapping("/nomina/admin/employees")
	public String listEmployees(ModelMap model) {
		logger.debug("Recuperando empleados por id rol user");
		model.put("employees", empleadoService.findByUsuarioRolId());
		return "/empleado/listEmployees";
	}
	
	
	
}

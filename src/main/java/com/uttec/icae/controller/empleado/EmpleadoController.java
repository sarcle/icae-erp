package com.uttec.icae.controller.empleado;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uttec.icae.model.Empleado;
import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.empleado.EmpleadoService;

@Controller
@SessionAttributes({ "usuario" })
public class EmpleadoController {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
	
	@Autowired
	private EmpleadoService empleadoService;
	
//	@Autowired
//	private EmpleadoWebService empleadoWebService;
	
//	@Autowired
//	private ReciboNominaService reciboNominaService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping("/nomina/employee/changePasswordForm")
	public String changePasswordForm(@ModelAttribute Usuario usuario, ModelMap model) {
		model.put("usuarioForm", usuario);
		return "empleado/changePasswordForm";
	}
	
	@RequestMapping("/nomina/employee/updateInfoForm")
	public String updateInfoForm(@ModelAttribute Usuario usuario, ModelMap model) {
		Empleado empleadoForm = new Empleado(usuario.getEmpleado().getId());
		Usuario usuarioForm = new Usuario(usuario.getId());
		empleadoForm.setUsuario(usuarioForm);
		model.put("empleadoForm", empleadoForm);
		model.put("usuarioForm", usuarioForm);
		model.put("emailActual", usuario.getEmpleado().getEmail());
		return "empleado/updateInfoForm";
	}
	
	@RequestMapping("/nomina/employee/changeEmail")
	public String changeEmail(@ModelAttribute Usuario usuario, @ModelAttribute Empleado empleado,
			ModelMap model, final RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.debug("en modifyInfo...");
		try {
			empleadoService.updateEmail(empleado);
			usuario.getEmpleado().setEmail(empleado.getEmail());
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.updateinfo", null, null));
			return "redirect:/nomina/menuPage";
//		} catch (PortalNominaException ex) {
		} catch (Exception ex) {
			redirectAttributes.addFlashAttribute("messageError", ex.getMessage());
			return "redirect:/nomina/employee/updateInfoForm";
		}
	}
	
//	@RequestMapping("/nomina/employee/paySlips")
//	public String listPaySlips(@ModelAttribute Usuario usuario, ModelMap model) {
//		List<ReciboNomina> recibos = reciboNominaService.findAllByIdEmpleado(usuario.getEmpleado());
//		logger.debug("recibos size " +  recibos.size());
//		model.put("recibos", recibos);
//		return "/empleado/listPaySlips";
//	}

	@RequestMapping("/resetPassword/resetForm")
	public String resetForm(ModelMap model) {
		model.put("empleado", new Empleado());
		model.put("isLoginPage", true);
		return "/empleado/resetForm";
	}
	
	
	@RequestMapping("/resetPassword/sendPassword")
	public String sendPassword(@ModelAttribute Empleado empleado, ModelMap model, 
			final RedirectAttributes redirectAttributes) {
//		empleado = empleadoService.findByRfcAndEmail(empleado);
//		if (empleado != null) {
//			empleadoWebService.resetPassword(empleado);
//			//FIXME OVP Cambiar mensaje para tomarlo de archivo de propiedades
//			redirectAttributes.addFlashAttribute("messageSuccess", "En unos momentos recibirá su nueva contraseña en el correo registrado.");
//			return "redirect:/resetPassword/resetForm";
//		} else {
//			//FIXME OVP Cambiar mensaje para tomarlo de archivo de propiedades
//			redirectAttributes.addFlashAttribute("messageError", "El usuario o el correo no se encuentra registrado en el sistema.");
//			return "redirect:/resetPassword/resetForm";
//		}
		return null;
	}
	
}

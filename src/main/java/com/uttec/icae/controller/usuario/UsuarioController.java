package com.uttec.icae.controller.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.usuario.UsuarioService;

@Controller
@SessionAttributes({ "usuario" })
public class UsuarioController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = {"/admin/changePassword", "/nomina/employee/changePassword"}, method = RequestMethod.POST)
	public String changePassword(@ModelAttribute Usuario usuario, ModelMap model,
			final RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.debug("en changePassword");
		usuarioService.save(usuario);
		usuario.setResetPassword(false);
		HttpSession session = request.getSession();
		session.setAttribute("resetPassword", usuario.getResetPassword());
		session.setAttribute("rol", usuario.getRol().getRol());
		redirectAttributes.addFlashAttribute("messageSuccess", 
				messageSource.getMessage("messages.success.update", null, null));
		return "redirect:/menuPage";
	}
}

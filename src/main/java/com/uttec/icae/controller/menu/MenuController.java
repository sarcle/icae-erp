package com.uttec.icae.controller.menu;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.uttec.icae.exception.IcaeErpException;
import com.uttec.icae.model.TipoRol;
import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.usuario.UsuarioService;

@Controller
@SessionAttributes({ "usuario" })
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/menu")
	public String menu(ModelMap model, Principal principal, HttpServletRequest request) {
		logger.debug("recuperando empleado por RFC");
		System.out.println("RECUPERANDO EMPLEADO");
		Usuario usuario = new Usuario();
		usuario.setUsername(principal.getName());
		usuario = usuarioService.findByUsername(usuario);
		model.put("usuario", usuario);
		HttpSession session = request.getSession(); 
		session.setAttribute("resetPassword", usuario.getResetPassword());
		session.setAttribute("rol", usuario.getRol().getRol());
		return "redirect:/menuPage";
	}
	
	@RequestMapping("/menuPage")
	public String menuPage(SecurityContextHolderAwareRequestWrapper securityContext) {
		System.out.println("----  HOLA ESTE @RequestMapping(\"/menuPage\")");
		if (securityContext.isUserInRole(TipoRol.USUARIO.getName())) {
			return "menu/menuEmployee";
		} else if (securityContext.isUserInRole(TipoRol.ADMINISTRADOR.getName())) {
			return "menu/menuAdministrator";
		} else {
			//FIXME OVP Tomar mensaje de properties
			throw new IcaeErpException("El usuario no cuenta con los permisos adecuados.");
		}
	}

}
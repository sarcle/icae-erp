package com.uttec.icae.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uttec.icae.exception.IcaeErpException;
import com.uttec.icae.model.TipoRol;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private static final String loginView = "login";
	private static final String loginAdmin = "menu/menuAdministrator";

	@RequestMapping("/")
	public String root() {
		System.out.println("----  HOLA ESTE ES ROOT");
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model) {
		logger.debug("login");
		System.out.println("----  HOLA ESTE ES /login");
		model.put("isLoginPage", true);
		return loginView;
//		return loginAdmin;
	}
	

	@RequestMapping("/loginFailed")
	public String loginError(ModelMap model) {
		logger.debug("loginFailed");
		model.put("error", true);
		model.put("isLoginPage", true);
		return loginView;
	}

	@RequestMapping("/sessionTimeout")
	public String sessionTimeout(ModelMap model) {
		logger.debug("Sesion expirada");
		return "login/sessionTimeout";
	}

	@RequestMapping("/logout")
	public String logout(ModelMap model) {
		model.put("isLoginPage", true);
		return "login/logoutSuccess";
	}
	
	@RequestMapping("/menuPage3")
	public String menuPage(SecurityContextHolderAwareRequestWrapper securityContext) {
		System.out.println("AQUI LLEGOooo");
			return "menu/menuAdministrator";
	}

}

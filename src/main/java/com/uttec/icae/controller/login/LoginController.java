package com.uttec.icae.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
//	private static final Logger logger = LoggerFactory
//			.getLogger(LoginController.class);

	private static final String loginView = "login";

	@RequestMapping("/")
	public String root() {
		System.out.println("----  HOLA ESTE ES ROOT");
		return "redirect:/menuPage";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model) {
//		logger.debug("login");
		System.out.println("----  HOLA ESTE ES /login");
		model.put("isLoginPage", true);
		return loginView;
	}

	@RequestMapping("/loginFailed")
	public String loginError(ModelMap model) {
//		logger.debug("loginFailed");
		model.put("error", true);
		model.put("isLoginPage", true);
		return loginView;
	}

	@RequestMapping("/sessionTimeout")
	public String sessionTimeout(ModelMap model) {
//		logger.debug("Sesion expirada");
		return "login/sessionTimeout";
	}

	@RequestMapping("/logout")
	public String logout(ModelMap model) {
		model.put("isLoginPage", true);
		return "login/logoutSuccess";
	}

}

package com.uttec.icae.controller.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController {

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping("/error")
	public String handlePageNotFound(ModelMap model) {
		return "redirect:/pageNotFound";
	}
	
	@RequestMapping("/pageNotFound")
	public String pageNotFound(ModelMap model) {
		model.put("isLoginPage", true);
		model.put("errMsg", messageSource.getMessage("messages.error.404", null, null));
		return "/error/custom404";
	}
}

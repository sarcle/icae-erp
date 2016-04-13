package com.uttec.icae.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UsuarioInterceptor extends HandlerInterceptorAdapter {
	
//	private static final Logger logger = LoggerFactory.getLogger(UsuarioInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		logger.debug("pre handle");
		boolean resetPassword = (Boolean) request.getSession().getAttribute("resetPassword");
		String rol = (String) request.getSession().getAttribute("rol");
		if (resetPassword) {
			if (rol.equals("ROLE_USER")) {
				response.sendRedirect("employee/changePasswordForm");
				return false;
			} else {
				response.sendRedirect("admin/changePasswordForm");
				return false;
			}
		} 
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
//		logger.debug("post handle, termino el proceso de validacion de password");
	}
}

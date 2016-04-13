package com.uttec.icae.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.uttec.icae.exception.IcaeErpException;

@ControllerAdvice
public class GlobalHandlerExceptionController {

//	private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerExceptionController.class);
	
	@ExceptionHandler(IcaeErpException.class)
	public ModelAndView handlePortalExceptions(IcaeErpException ex) {
		ModelAndView mav = new ModelAndView("error/portalError");
		mav.addObject("errMsg", ex.getMessage());
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllExceptions(Exception ex) {
		ModelAndView mav = new ModelAndView("error/genericError");
//		logger.error("Ocurrió un error: ", ex);
		mav.addObject("errMsg", ex);
		return mav;
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handlerDataAccesException(DataAccessException ex) {
		ModelAndView mav = new ModelAndView("error/dataError");
//		logger.error("Ocurrió un error: ", ex);
		mav.addObject("errMsg", ex);
		return mav;
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String restartFlow(HttpServletRequest request) {
//		logger.debug("redireccionando session incompleta");
		return "redirect:/portal/menuPage";
	}
}

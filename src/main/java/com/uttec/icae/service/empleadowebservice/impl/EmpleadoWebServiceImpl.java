package com.uttec.icae.service.empleadowebservice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.uttec.icae.model.Empleado;
import com.uttec.icae.service.empleado.EmpleadoService;
import com.uttec.icae.service.empleadowebservice.EmpleadoWebService;

@Service("empleadoWebService")
public class EmpleadoWebServiceImpl implements EmpleadoWebService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpleadoWebServiceImpl.class);
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Async
	@Override
	public void resetPassword(Empleado empleado) {
		logger.debug("Reseteando password");
		empleadoService.resetPassword(empleado);
	}

}

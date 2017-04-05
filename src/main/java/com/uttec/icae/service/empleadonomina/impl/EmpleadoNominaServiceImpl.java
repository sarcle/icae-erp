package com.uttec.icae.service.empleadonomina.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.empleadonomina.EmpleadoNominaRepository;
import com.uttec.icae.model.EmpleadoNomina;
import com.uttec.icae.service.empleadonomina.EmpleadoNominaService;

@Service("empleadoNominaService")
public class EmpleadoNominaServiceImpl implements EmpleadoNominaService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpleadoNominaServiceImpl.class);
	
	@Autowired
	private EmpleadoNominaRepository empleadoNominaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<EmpleadoNomina> findAll() {
		logger.debug("Recuperando todos los productos");
		return empleadoNominaRepository.findAll();
	}
	
	
	@Transactional
	@Override
	public void update(EmpleadoNomina updated) {
		EmpleadoNomina empleadoNominaUpdated = empleadoNominaRepository.findOne(updated.getId());
//		empleadoNominaUpdated.setCantMin(updated.getCantMin());
		empleadoNominaRepository.saveAndFlush(empleadoNominaUpdated);
	}
	
	@Transactional
	@Override
	public void save(EmpleadoNomina empleadoNomina) {
		empleadoNomina.setId(empleadoNominaRepository.save(empleadoNomina).getId());
	}
	
	@Transactional(readOnly = true)
	@Override
	public EmpleadoNomina findOne(EmpleadoNomina empleadoNomina) {
		return empleadoNominaRepository.findOne(empleadoNomina.getId());
	}

}

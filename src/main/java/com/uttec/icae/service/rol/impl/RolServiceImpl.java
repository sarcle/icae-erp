package com.uttec.icae.service.rol.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.rol.RolRepository;
import com.uttec.icae.model.Rol;
import com.uttec.icae.service.rol.RolService;

@Service("rolService")
public class RolServiceImpl implements RolService {

	private static final Logger logger = LoggerFactory.getLogger(RolServiceImpl.class);
	
	@Autowired
	private RolRepository rolRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Rol findOne(Rol rol) {
		logger.debug("en findById...");
		logger.debug("id rol...{}", rol.getId());
		return rolRepository.findOne(rol.getId());
	}
}
package com.uttec.icae.service.configicae.empresa.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.empresa.EmpresaRepository;
import com.uttec.icae.model.Empresa;
import com.uttec.icae.service.configicae.empresa.EmpresaService;

@Service("empresaService")
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Empresa findOne(Empresa empresa) {
		return empresaRepository.findOne(empresa.getId());
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

}

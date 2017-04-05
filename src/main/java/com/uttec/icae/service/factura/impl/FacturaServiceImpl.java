package com.uttec.icae.service.factura.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.factura.FacturaRepository;
import com.uttec.icae.model.Factura;
import com.uttec.icae.model.Producto;
import com.uttec.icae.service.factura.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService {

	
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Transactional
	@Override
	public void save(Factura factura) {
		factura.setId(facturaRepository.save(factura).getId());
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}
	

}

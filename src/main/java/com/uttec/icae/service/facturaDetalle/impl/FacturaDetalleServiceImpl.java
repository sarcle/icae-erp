package com.uttec.icae.service.facturaDetalle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.facturadetalle.FacturaDetalleRepository;
import com.uttec.icae.model.FacturaDetalle;
import com.uttec.icae.service.facturaDetalle.FacturaDetalleService;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

	@Autowired
	private FacturaDetalleRepository facturaDetalleRepository;
	
	@Transactional
	@Override
	public void save(FacturaDetalle facturaDetalle) {
		facturaDetalleRepository.save(facturaDetalle);
	}

	@Transactional
	@Override
	public void save(List<FacturaDetalle> facturaDetalles) {
		facturaDetalleRepository.save(facturaDetalles);
	}
	
	
}

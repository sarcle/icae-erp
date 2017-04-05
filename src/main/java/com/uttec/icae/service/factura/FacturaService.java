package com.uttec.icae.service.factura;

import java.util.List;

import com.uttec.icae.model.Factura;

public interface FacturaService {

	void save(Factura factura);

	List<Factura> findAll();

}

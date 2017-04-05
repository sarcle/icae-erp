package com.uttec.icae.service.facturaDetalle;

import java.util.List;

import com.uttec.icae.model.FacturaDetalle;

public interface FacturaDetalleService {

	void save(FacturaDetalle facturaDetalle);

	void save(List<FacturaDetalle> facturaDetalles);

}

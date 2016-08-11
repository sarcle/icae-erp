package com.uttec.icae.service.producto;

import java.util.List;

import com.uttec.icae.model.Empleado;
import com.uttec.icae.model.Producto;

public interface ProductoService {

	Producto findByClave(Producto producto);

	List<Producto> findAll();

	void update(Producto updated);

	void save(Producto producto);

	Producto findOne(Producto producto);

}

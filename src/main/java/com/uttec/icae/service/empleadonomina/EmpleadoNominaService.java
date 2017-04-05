package com.uttec.icae.service.empleadonomina;

import java.util.List;

import com.uttec.icae.model.EmpleadoNomina;
import com.uttec.icae.model.Producto;

public interface EmpleadoNominaService {

	List<EmpleadoNomina> findAll();

	void update(EmpleadoNomina updated);

	void save(EmpleadoNomina empleadoNomina);

	EmpleadoNomina findOne(EmpleadoNomina empleadoNomina);

}

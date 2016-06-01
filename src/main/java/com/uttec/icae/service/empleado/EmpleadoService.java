package com.uttec.icae.service.empleado;

import java.util.List;

import com.uttec.icae.model.Empleado;

public interface EmpleadoService {

	Empleado findByRfc(Empleado empleado);

	void updateEmail(Empleado empleado);

	List<Empleado> findByUsuarioRolId();

	void save(Empleado empleado);

	Empleado findOne(Empleado empleado);

	void update(Empleado empleado);

	Empleado findByRfcAndEmail(Empleado empleado);

	void resetPassword(Empleado empleado);

}

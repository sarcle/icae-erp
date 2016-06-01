package com.uttec.icae.dao.empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttec.icae.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	Empleado findByRfc(String rfc);

	List<Empleado> findByUsuarioRolId(Long rolId);

	Empleado findByRfcAndEmail(String rfc, String email);

}

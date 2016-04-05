package com.uttec.icae.dao.rol;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttec.icae.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

	Rol findByRol(String string);
	
}

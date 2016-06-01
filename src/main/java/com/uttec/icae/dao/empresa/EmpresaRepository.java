package com.uttec.icae.dao.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttec.icae.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}

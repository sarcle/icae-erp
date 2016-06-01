package com.uttec.icae.service.configicae.empresa;

import java.util.List;

import com.uttec.icae.model.Empresa;

public interface EmpresaService {

	Empresa findOne(Empresa empresa);

	List<Empresa> findAll();

}

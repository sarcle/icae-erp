package com.uttec.icae.service.cliente;

import java.util.List;

import com.uttec.icae.model.Cliente;

public interface ClienteService {

	Cliente findByRfc(Cliente cliente);

	Cliente findByEmail(Cliente cliente);

	void update(Cliente cliente);

	void updateEmail(Cliente updated);

	void save(Cliente cliente);

	Cliente findOne(Cliente cliente);

	Cliente findByRfcAndEmail(Cliente cliente);

	Object findAll();

}

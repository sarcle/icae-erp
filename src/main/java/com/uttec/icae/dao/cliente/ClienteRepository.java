package com.uttec.icae.dao.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttec.icae.model.Cliente;


public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

	Cliente findByRfc(String rfc);

	Cliente findByEmail(String email);

	Cliente findByRfcAndEmail(String rfc, String email);

}

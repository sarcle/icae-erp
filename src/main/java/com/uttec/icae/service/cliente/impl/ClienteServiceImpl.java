package com.uttec.icae.service.cliente.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.cliente.ClienteRepository;
import com.uttec.icae.dao.rol.RolRepository;
import com.uttec.icae.model.Cliente;
import com.uttec.icae.model.Rol;
import com.uttec.icae.model.TipoRol;
import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.cliente.ClienteService;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService, ResourceLoaderAware{
	private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
//	@Autowired
//	private MailService mailService;
	
	@Autowired
	private MessageSource messageSource;

	private ResourceLoader resourceLoader;
	
	@Transactional(readOnly = true)
	@Override
	public Cliente findByRfc(Cliente cliente) {
		logger.debug("Recuperando cliente por RFC");
		return clienteRepository.findByRfc(cliente.getRfc());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Cliente findByEmail(Cliente cliente) {
		logger.debug("Recuperando cliente por Mail");
		return clienteRepository.findByEmail(cliente.getEmail());
	}
	
	@Transactional
	@Override
	public void update(Cliente updated) {
		Cliente clienteForUpdate = clienteRepository.findOne(updated.getId());
		clienteForUpdate = updated;
		clienteRepository.saveAndFlush(clienteForUpdate);
	}
	
	@Transactional
	@Override
	public void updateEmail(Cliente updated) {
		if (!updated.getEmail().isEmpty()) {
			Cliente clienteForUpdate = clienteRepository.findOne(updated.getId());
			clienteForUpdate.setEmail(updated.getEmail());
			clienteRepository.saveAndFlush(clienteForUpdate);
		} else {
//			throw new PortalNominaException(messageSource.getMessage("messages.error.empty.updateinfo", null, null));
//			throw new Exception(messageSource.getMessage("messages.error.empty.updateinfo", null, null));
		}
	}
	
	@Transactional
	@Override
	public void save(Cliente cliente) {
		Rol rol = rolRepository.findByRol(TipoRol.USUARIO.getName());
		Usuario usuario = new Usuario();
		usuario.setUsername(cliente.getRfc());
		usuario.setResetPassword(true);
        usuario.setRol(rol);
		clienteRepository.save(cliente);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Cliente findOne(Cliente cliente) {
		return clienteRepository.findOne(cliente.getId());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Cliente findByRfcAndEmail(Cliente cliente) {
		return clienteRepository.findByRfcAndEmail(cliente.getRfc(), cliente.getEmail());
	}
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		logger.debug("Recuperando todos los clientes");
		return clienteRepository.findAll();
	}
	
}

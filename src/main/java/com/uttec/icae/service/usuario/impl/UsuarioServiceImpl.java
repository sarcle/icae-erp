package com.uttec.icae.service.usuario.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.usuario.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoderService passwordEncoderService; 
	
	@Transactional(readOnly = true)
	@Override
	public Usuario findByUsername(Usuario usuario) {
		logger.debug("en findByUsername...");
		return usuarioRepository.findByUsername(usuario.getUsername());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Usuario findByUsernameNoPassword(Usuario usuario) {
		logger.debug("en findByUsernameNoPassword...");
		return usuarioRepository.findByUsernameNoPassword(usuario.getUsername());
	}
	
	@Transactional
	@Override
	public void save(Usuario updated) {
		if (!updated.getPassword().isEmpty()) {
			Usuario usuario = usuarioRepository.getOne(updated.getId());
			usuario.setPassword(passwordEncoderService.getPasswordEncoded(updated.getPassword()));
			usuario.setResetPassword(false);
			usuarioRepository.saveAndFlush(usuario);
		}
	}

}

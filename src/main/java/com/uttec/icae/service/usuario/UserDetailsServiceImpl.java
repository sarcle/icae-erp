package com.uttec.icae.service.usuario;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.exception.IcaeErpException;
import com.uttec.icae.model.Rol;
import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.rol.RolService;

public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.debug("en loadUserByUsername...");
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario = usuarioService.findByUsername(usuario);
		
		if (usuario == null) {
			throw new UsernameNotFoundException(messageSource.getMessage("login.failed", null, null));
		}
		
		return buildUserFromUsuario(usuario);
	}

	private UserDetails buildUserFromUsuario(Usuario usuario) {
		String username = usuario.getUsername();
		String password = usuario.getPassword();
		boolean enabled = usuario.getEnabled();
		boolean accountNonExpired = true;
		boolean accountNonLocked = true;
		boolean credentialsNonExpired = true;
		List<SimpleGrantedAuthority> authorities = getAuthorities(usuario);
		User user = new User(username, password, enabled, accountNonExpired, 
				credentialsNonExpired, accountNonLocked, authorities);
		return user;
	}

	private List<SimpleGrantedAuthority> getAuthorities(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		Rol rol = rolService.findOne(usuario.getRol());
		if (rol != null) {
			authorities.add(new SimpleGrantedAuthority(rol.getRol()));
		} else {
			throw new IcaeErpException(messageSource.getMessage("login.authorities.empty", null, null));
		}
		
		return authorities;
	}

}
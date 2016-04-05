package com.uttec.icae.service.usuario;

import com.uttec.icae.model.Usuario;

public interface UsuarioService {

	Usuario findByUsername(Usuario usuario);

	Usuario findByUsernameNoPassword(Usuario usuario);

	void save(Usuario usuario);

}

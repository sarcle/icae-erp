package com.uttec.icae.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uttec.icae.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

	@Query("SELECT u.username, u.resetPassword from Usuario u WHERE u.username = :username")
	Usuario findByUsernameNoPassword(@Param("username") String username);

}

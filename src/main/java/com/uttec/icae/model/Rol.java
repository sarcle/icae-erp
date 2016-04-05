package com.uttec.icae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1672480003240006246L;
	
	@Id
	@Column(name = "id_rol", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rol;
	
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rol [id=");
		builder.append(id);
		builder.append(", rol=");
		builder.append(rol);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}

}

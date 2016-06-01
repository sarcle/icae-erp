package com.uttec.icae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = -8107457985974942667L;
	
	@Id
	@Column(name = "id_empresa", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rfc;
	
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empresa [id=");
		builder.append(id);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

}

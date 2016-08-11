package com.uttec.icae.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = -5591292056035988082L;

	@Id
	@Column(name = "id_empleado", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	@Column(unique = true)
	private String rfc;
	
	private String nombre;
	
	@Column(unique = true)
	private String email;
	
//	@Transient
//	private List<ReciboNomina> recibosNomina;

	public Empleado() {
	}
	
	public Empleado(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public List<ReciboNomina> getRecibosNomina() {
//		return recibosNomina;
//	}
//
//	public void setRecibosNomina(List<ReciboNomina> recibosNomina) {
//		this.recibosNomina = recibosNomina;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleado [id=");
		builder.append(id);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", empresa=");
		builder.append(empresa);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", email=");
		builder.append(email);
		builder.append(", recibosNomina=");
//		builder.append(recibosNomina);
		builder.append("]");
		return builder.toString();
	}

}

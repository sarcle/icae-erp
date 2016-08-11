package com.uttec.icae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_producto")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 3050669048710990286L;
	
	@Id
	@Column(name = "id_producto", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String clave;
	
	private String descripcion;
	private String presentacion;
	
	@Column(name = "cant_max")
	private double cantMax;
	
	@Column(name = "cant_min")
	private double cantMin;
	
	private double precio;
	
	@Column(name = "no_existencias")
	private int noExistencias;
	
	public Producto() {
	}
	
	public Producto(Long id) {
		super();
		this.id = id;
	}


	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public double getCantMax() {
		return cantMax;
	}
	public void setCantMax(double cantMax) {
		this.cantMax = cantMax;
	}
	public double getCantMin() {
		return cantMin;
	}
	public void setCantMin(double cantMin) {
		this.cantMin = cantMin;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getNoExistencias() {
		return noExistencias;
	}
	public void setNoExistencias(int noExistencias) {
		this.noExistencias = noExistencias;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result
				+ ((presentacion == null) ? 0 : presentacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (presentacion == null) {
			if (other.presentacion != null)
				return false;
		} else if (!presentacion.equals(other.presentacion))
			return false;
		return true;
	}
	
	
}

package com.uttec.icae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_factura_detalle")
public class FacturaDetalle implements Serializable {

	private static final long serialVersionUID = 2386365967223187682L;

	@Id
	@Column(name = "id_factura")
	private Long id;
	
	private double cantidad;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	@Column(name = "precio_venta")
	private double precioVenta;
	
	private double importe;

	public FacturaDetalle() {
	}
	
	public FacturaDetalle(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precio_venta) {
		this.precioVenta = precio_venta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}

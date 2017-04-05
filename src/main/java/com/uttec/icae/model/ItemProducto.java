package com.uttec.icae.model;

public class ItemProducto {

	private Long clave;
	private double cantidad;
	private double precio;
	private double importe;
	
	public Long getClave() {
		return clave;
	}

	public void setClave(Long clave) {
		this.clave = clave;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "ItemProducto [clave=" + clave + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", importe=" + importe + "]";
	}
}

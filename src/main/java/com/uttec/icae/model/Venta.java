package com.uttec.icae.model;

import java.util.List;

public class Venta {

	private String cliente;
	private double subtotal; 
	private double iva; 
	private double total;
	
	private List<ItemProducto> listProductos;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ItemProducto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<ItemProducto> listProductos) {
		this.listProductos = listProductos;
	}

	@Override
	public String toString() {
		return "Venta [cliente=" + cliente + ", subtotal=" + subtotal
				+ ", iva=" + iva + ", total=" + total + ", listProductos="
				+ listProductos + "]";
	}
}

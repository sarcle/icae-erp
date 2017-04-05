package com.uttec.icae.model;

public enum TipoRol {
	ADMINISTRADOR("ROLE_ADMIN"),
	USUARIO("ROLE_USER"), 
	USUARIO_INVENTARIO("ROLE_INVENTARIO"),
	USUARIO_FACTURACION("ROLE_FACTURACION"), 
	USUARIO_NOMINA("ROLE_NOMINA");
	
	private String name;
	
	private TipoRol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

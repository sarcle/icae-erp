package com.uttec.icae.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_config_icae")
public class ConfigIcae implements Serializable {

	private static final long serialVersionUID = -3275808974018458350L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String pathRecibos;

	private String logoUrl;
	
	private String appTitle;

	public ConfigIcae() {
	}

	public ConfigIcae(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPathRecibos() {
		return pathRecibos;
	}

	public void setPathRecibos(String pathRecibos) {
		this.pathRecibos = pathRecibos;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	public String getAppTitle() {
		return appTitle;
	}
	
	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}

}

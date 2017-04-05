package com.uttec.icae.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity
//@Table(name = "t_recibo_nomina")
public class ReciboNomina implements Serializable {

	private static final long serialVersionUID = -1025206111358587961L;

//	@Id
//	@Column(name = "id_recibo", unique = true)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@ManyToOne(optional = false)
//	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

//	@Temporal(TemporalType.DATE)
	private Date fechaEmision;

//	@Temporal(TemporalType.DATE)
	private Date fechaInicialPago;

//	@Temporal(TemporalType.DATE)
	private Date fechaFinalPago;

//	@Temporal(TemporalType.DATE)
	private Date fechaPago;

	private Date fechaTimbrado;

	private String uuid;

	private String pathRecibos;

	private String filenameForDownload;
	
	private String xmlFilename;

	private String pdfFilename;

	@Transient
	private byte[] xmlBytes;

	@Transient
	private byte[] pdfBytes;

	public ReciboNomina() {
	}

	public ReciboNomina(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaInicialPago() {
		return fechaInicialPago;
	}

	public void setFechaInicialPago(Date fechaInicialPago) {
		this.fechaInicialPago = fechaInicialPago;
	}

	public Date getFechaFinalPago() {
		return fechaFinalPago;
	}

	public void setFechaFinalPago(Date fechaFinalPago) {
		this.fechaFinalPago = fechaFinalPago;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaTimbrado() {
		return fechaTimbrado;
	}

	public void setFechaTimbrado(Date fechaTimbrado) {
		this.fechaTimbrado = fechaTimbrado;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPathRecibos() {
		return pathRecibos;
	}

	public void setPathRecibos(String pathRecibos) {
		this.pathRecibos = pathRecibos;
	}

	public String getFilenameForDownload() {
		return filenameForDownload;
	}

	public void setFilenameForDownload(String filenameForDownload) {
		this.filenameForDownload = filenameForDownload;
	}

	public String getXmlFilename() {
		return xmlFilename;
	}

	public void setXmlFilename(String xmlFilename) {
		this.xmlFilename = xmlFilename;
	}

	public String getPdfFilename() {
		return pdfFilename;
	}

	public void setPdfFilename(String pdfFilename) {
		this.pdfFilename = pdfFilename;
	}

	public byte[] getXmlBytes() {
		return xmlBytes;
	}

	public void setXmlBytes(byte[] xmlBytes) {
		this.xmlBytes = xmlBytes;
	}

	public byte[] getPdfBytes() {
		return pdfBytes;
	}

	public void setPdfBytes(byte[] pdfBytes) {
		this.pdfBytes = pdfBytes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReciboNomina [id=");
		builder.append(id);
		builder.append(", empleado=");
		builder.append(empleado);
		builder.append(", fechaEmision=");
		builder.append(fechaEmision);
		builder.append(", fechaInicialPago=");
		builder.append(fechaInicialPago);
		builder.append(", fechaFinalPago=");
		builder.append(fechaFinalPago);
		builder.append(", fechaPago=");
		builder.append(fechaPago);
		builder.append(", fechaTimbrado=");
		builder.append(fechaTimbrado);
		builder.append(", uuid=");
		builder.append(uuid);
		builder.append(", pathRecibos=");
		builder.append(pathRecibos);
		builder.append(", filenameForDownload=");
		builder.append(filenameForDownload);
		builder.append(", xmlFilename=");
		builder.append(xmlFilename);
		builder.append(", pdfFilename=");
		builder.append(pdfFilename);
		builder.append("]");
		return builder.toString();
	}

}

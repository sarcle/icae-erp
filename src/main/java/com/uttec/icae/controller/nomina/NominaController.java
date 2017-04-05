package com.uttec.icae.controller.nomina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.aspectj.weaver.patterns.PerSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.certus.facturehoy.ws2.cfdi.WsEmisionTimbrado;
import com.certus.facturehoy.ws2.cfdi.WsEmisionTimbradoService;
import com.certus.facturehoy.ws2.cfdi.WsResponseBO;
import com.certus.facturehoy.ws2.cfdi.WsServicioBO;
import com.certus.facturehoy.ws2.cfdi.WsServicios;
import com.certus.facturehoy.ws2.cfdi.WsServiciosService;
import com.icae.model.cfdi.v32.Comprobante;
import com.icae.model.cfdi.v32.Comprobante.Complemento;
import com.icae.model.cfdi.v32.Comprobante.Conceptos;
import com.icae.model.cfdi.v32.Comprobante.Emisor;
import com.icae.model.cfdi.v32.Comprobante.Impuestos;
import com.icae.model.cfdi.v32.Comprobante.Receptor;
import com.icae.model.cfdi.v32.Comprobante.Conceptos.Concepto;
import com.icae.model.cfdi.v32.Comprobante.Emisor.RegimenFiscal;
import com.icae.model.cfdi.v32.Comprobante.Impuestos.Retenciones;
import com.icae.model.cfdi.v32.Comprobante.Impuestos.Retenciones.Retencion;
import com.icae.model.nomina.v32.Nomina;
import com.icae.model.nomina.v32.Nomina.Deducciones;
import com.icae.model.nomina.v32.Nomina.Deducciones.Deduccion;
import com.icae.model.nomina.v32.Nomina.Percepciones;
import com.icae.model.nomina.v32.Nomina.Percepciones.Percepcion;
import com.uttec.icae.model.EmpleadoNomina;
import com.uttec.icae.model.Factura;
import com.uttec.icae.model.FacturaDetalle;
import com.uttec.icae.service.empleadonomina.EmpleadoNominaService;
import com.uttec.icae.utils.IcaeErpUtils;

@Controller
@SessionAttributes({ "usuario" })
public class NominaController {
	private static final Logger logger = LoggerFactory
			.getLogger(NominaController.class);
	
	@Autowired
	private EmpleadoNominaService empleadoNominaService;		
			
	@Autowired
	private MessageSource messageSource;
	
	public String carpetaDefault = "C:\\NOMINA";
	
	File fileXml;
	
	@RequestMapping("/nomina/admin/empleadosNomina")
	public String listEmpleadoNomina(ModelMap model) {
		logger.debug("Recuperando empleados");
		model.put("empleadosNomina", empleadoNominaService.findAll());
		return "/nomina/listEmpleadosNomina";
	}
		
	@RequestMapping("/nomina/admin/newEmpleadoNomina")
	public String newEmpleadoNomina (ModelMap model) {
		logger.debug("Alta de nuevo empleadoNomina");
		model.put("empleadoNomina", new EmpleadoNomina());
		return "/nomina/empleadoNominaForm";
	}
	
	@RequestMapping("/nomina/admin/timbrarNomina")
	public String timbrarNomina (ModelMap model) {
		logger.debug("Timbrar nomina");
		List<EmpleadoNomina> empleados = empleadoNominaService.findAll();
		for (EmpleadoNomina empleadoNomina : empleados) {
			Comprobante comprobante = crearXmlNomina(empleadoNomina);
			timbrarComprobante(comprobante, empleadoNomina);
		}
		return "redirect:/menuPage";
	}
	
	@RequestMapping("/nomina/admin/modifyEmpleadoNomina/{id}")
	public String modifyEmpleadoNomina(ModelMap model, @PathVariable("id") Long id) {
		EmpleadoNomina empleadoNomina = new EmpleadoNomina(id);
		empleadoNomina = empleadoNominaService.findOne(empleadoNomina);
		model.put("empleadoNomina", empleadoNomina);
		return "/nomina/empleadoNominaForm";
	}
	
	@RequestMapping(value = {"/nomina/admin/saveEmpleado"}, method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute EmpleadoNomina empleadoNomina, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		if (empleadoNomina.getId() != null) {
			empleadoNominaService.update(empleadoNomina);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.update", null, null));
		} else {
			empleadoNominaService.save(empleadoNomina);
			
			
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.save", null, null));
		}
		return "redirect:/nomina/admin/empleadosNomina";
	}
	
	
	//FIXME APRTIR DE AQUI MOVER A LA LOGIZA DE NEGOCIO
	
	
	public Comprobante crearXmlNomina(EmpleadoNomina empleadoNomina) {
		Comprobante comprobante = new Comprobante();
		comprobante.setVersion("3.2");
		comprobante.setFecha(crearFechaComprobante());
		comprobante.setSello("");
		comprobante.setFormaDePago("99");
		comprobante.setNoCertificado("xxxxxxxxxxxxxxxxxxxx");
		comprobante.setCertificado("");
		comprobante.setSubTotal(new BigDecimal(empleadoNomina.getSueldo()).setScale(2, BigDecimal.ROUND_UP));
		comprobante.setTotal(new BigDecimal(empleadoNomina.getSueldo()).setScale(2, BigDecimal.ROUND_UP));
		comprobante.setTipoDeComprobante("egreso");
		comprobante.setMetodoDePago("01");
		comprobante.setLugarExpedicion("Mexico, Mexico");
		//EMISOR
		Emisor emisor = new Emisor();
		emisor.setNombre("ICAE");
		emisor.setRfc("AAA010101AAA");
		//REGIMEN FISCAL DEL EMISOR
		RegimenFiscal regimenFiscal = new RegimenFiscal();
		regimenFiscal.setRegimen("Regimen fiscal de prueba");
		emisor.getRegimenFiscal().add(regimenFiscal);
		//AGREGANDO EL EMISOR AL COMPROBANTE
		comprobante.setEmisor(emisor);
		
		//RECEPTOR
		Receptor receptor = new Receptor();
		receptor.setNombre(empleadoNomina.getNombre() + " " + empleadoNomina.getApellidoPaterno() + " " + empleadoNomina.getApellidoMaterno());
		receptor.setRfc(empleadoNomina.getRfc());
		// AGREGANDO EL RECEPTOR AL COMPROBANTE
		comprobante.setReceptor(receptor);
		
		//CONCEPTOS
		Conceptos conceptos = new Conceptos();
		Concepto concepto = new Concepto();
		concepto.setCantidad(BigDecimal.ONE);
		concepto.setDescripcion("PAGO DE NOMINA");
		concepto.setImporte(new BigDecimal(empleadoNomina.getSueldo()).setScale(2, BigDecimal.ROUND_UP));
		concepto.setUnidad("SERVICIO");
		concepto.setValorUnitario(new BigDecimal(empleadoNomina.getSueldo()).setScale(2, BigDecimal.ROUND_UP));
		conceptos.getConcepto().add(concepto);
		
		//AGEGANDO CONCEPTO A CONCEPTOS Y COMPROBANTE
		comprobante.setConceptos(conceptos);
		//RETENCIONES
		Retencion retencion = new Retencion();
		retencion.setImporte(BigDecimal.ZERO);
		retencion.setImpuesto("ISR");
		//AGREGANDO RETENCION AL COMPROBANTE
		Impuestos impuestos = new Impuestos();
		Retenciones retenciones  = new Retenciones();
		retenciones.getRetencion().add(retencion);
		impuestos.setRetenciones(retenciones);
		comprobante.setImpuestos(impuestos); 
		
		// COMPLEMENTO NOMINA
		Nomina nomina = new Nomina();
		nomina.setVersion("1.1");
		nomina.setNumEmpleado(empleadoNomina.getId().toString());
		nomina.setCURP(empleadoNomina.getCurp());
		nomina.setTipoRegimen(2);
		nomina.setFechaPago(crearFechaComprobante());
		nomina.setFechaInicialPago(crearFechaComprobante());
		nomina.setFechaFinalPago(crearFechaComprobante());
		nomina.setNumDiasPagados(new BigDecimal(empleadoNomina.getDiasPagados()).setScale(2, BigDecimal.ROUND_UP));
		nomina.setPeriodicidadPago(empleadoNomina.getTipoNomina());
		
		//PERCEPCIONES
		Percepcion percepcion = new Percepcion();
		percepcion.setClave("001");
		percepcion.setConcepto("SUELDOS");
		percepcion.setImporteExento(new BigDecimal(empleadoNomina.getSueldo()).setScale(2, BigDecimal.ROUND_UP));
		percepcion.setImporteGravado(BigDecimal.ZERO);
		percepcion.setTipoPercepcion("001");
		
		//DEDUCCIONES
		Deduccion deduccion = new Deduccion();
		deduccion.setClave("002");
		deduccion.setConcepto("ISR");
		deduccion.setImporteExento(BigDecimal.ZERO);
		deduccion.setImporteGravado(BigDecimal.ZERO);
		deduccion.setTipoDeduccion("002");
		
		Percepciones percepciones  = new Percepciones();
		Deducciones deducciones = new Deducciones();
		
		percepciones.getPercepcion().add(percepcion);
		percepciones.setTotalExento(new BigDecimal(empleadoNomina.getSueldo()).setScale(2, BigDecimal.ROUND_UP));
		percepciones.setTotalGravado(BigDecimal.ZERO);
		
		deducciones.getDeduccion().add(deduccion);
		deducciones.setTotalExento(BigDecimal.ZERO);
		deducciones.setTotalGravado(BigDecimal.ZERO);
		
		//AGREGANDO PERCEPCIONES Y DEDUCCIONES AL COMPLEMENTO DE NOMINA
		nomina.setPercepciones(percepciones);
		nomina.setDeducciones(deducciones);
		
		// AGREGANDO NOMINA AL COMPLEMENTO
		Complemento complemento = new Complemento();
		complemento.getAny().add(nomina);
		
		
		comprobante.setComplemento(complemento);
		
		
		return comprobante;
	}
	
	
	private XMLGregorianCalendar crearFechaComprobante() {
		Calendar dateNow = Calendar.getInstance();
		XMLGregorianCalendar fechaComprobante = null;
		try {
			fechaComprobante = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(dateNow.get(Calendar.YEAR),
							dateNow.get(Calendar.MONTH) + 1,
							dateNow.get(Calendar.DAY_OF_MONTH),
							dateNow.get(Calendar.HOUR_OF_DAY),
							dateNow.get(Calendar.MINUTE),
							dateNow.get(Calendar.SECOND),
							DatatypeConstants.FIELD_UNDEFINED,
							DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return fechaComprobante;
	}
	
	private void timbrarComprobante(Comprobante comprobante, EmpleadoNomina empleadoNomina) {
		converComprobanteToFile(comprobante, empleadoNomina);
		
		timbraXML(fileXml);
	}



	private void converComprobanteToFile(Comprobante comprobante, EmpleadoNomina empleadoNomina) {
		
		try {
			IcaeErpUtils.getXML(creaNombreXml(comprobante, empleadoNomina), comprobante);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private FileOutputStream creaNombreXml(Comprobante comprobante,  EmpleadoNomina empleadoNomina) {
		FileOutputStream fos = null;
		try {
			fileXml = new File(carpetaDefault  + File.separator + "RECIBO_NOMINA" + empleadoNomina.getId() + ".xml"); 
			 fos = new FileOutputStream(fileXml);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fos;
	}
	
	private void timbraXML(File xml) {
		
		WsServiciosService services = new WsServiciosService();
		WsServicios port = services.getWsServiciosPort();
		int idServicio = 0;
		String usuario = "AAA010101AAA.Test.User";
		String pass = "Prueba$1";
		// Se obtienen los servicios, pasando como parámetros el usuario y la contraseña
		WsServicioBO serviciosContratados = port.obtenerServicios(usuario, pass);
		// Se verifica que el arreglo del objeto NO esté vacío
		if (serviciosContratados.getArray().size() > 0) {
			// Se crea una instancia de un objeto WsServicioBO
			WsServicioBO servicioItem = new WsServicioBO();
			// Se recorre el arreglo y se almacena cada elemento en el
			// objeto que se acaba de crear
			Iterator<WsServicioBO> iteraServicio = serviciosContratados
					.getArray().iterator();
			while (iteraServicio.hasNext()) {
				servicioItem = iteraServicio.next();
				System.out.println(servicioItem.getIdProcess());
				System.out.println(servicioItem.getNombreServicio());
				idServicio = servicioItem.getIdProcess();
				if (servicioItem.getUltimoFolioUsado() < servicioItem.getCantidadCFDI())
					break;
			}
			// Se instancia el Web Service y se ejecuta el método de timbrado
			// Comentar para pruebas en real
			idServicio = 26190299;
			WsEmisionTimbradoService servicet = new WsEmisionTimbradoService();
			WsEmisionTimbrado portt = servicet.getWsEmisionTimbradoPort();
			WsResponseBO response = null;
			response = portt.emitirTimbrar(usuario, pass, idServicio, 	IcaeErpUtils.getBytes(xml));
//				response = portt.recuperarAcuse(usuario, pass,	DocumentoDAO.getDoc_cfdiUUIDExt(Conexion, doc_pendDTO));
			System.out.println(response.getMessage());
			// Se verifica que no haya ocurrido error
			boolean bandera = false;
			if (response.isIsError() == false) {
				// Se imprimen los datos
				String msg = "Proceso Exitoso\n" + "UUID\n\t: " + response.getFolioUDDI();
				msg += "\n\n" + "Cadena Original: \n\t" + response.getCadenaOriginal();
				msg += "\n\n" + "Sello Emisor: \n\t" + response.getSelloDigitalEmisor();
				msg += "\n\n" + "Sello Timbre: \n\t" + response.getSelloDigitalTimbreSAT();
				msg += "\n\n" + "Fecha/Hora timbrado: \n\t" + response.getFechaHoraTimbrado();
				logger.info(msg);
				if (response.getXML() != null) {
					IcaeErpUtils.generaXML(response.getXML(), xml.getAbsolutePath().toString());
				}
			}
		}
	}

}

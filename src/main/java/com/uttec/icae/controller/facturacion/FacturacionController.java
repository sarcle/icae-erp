package com.uttec.icae.controller.facturacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.certus.facturehoy.ws2.cfdi.WsEmisionTimbrado;
import com.certus.facturehoy.ws2.cfdi.WsEmisionTimbradoService;
import com.certus.facturehoy.ws2.cfdi.WsResponseBO;
import com.certus.facturehoy.ws2.cfdi.WsServicioBO;
import com.certus.facturehoy.ws2.cfdi.WsServicios;
import com.certus.facturehoy.ws2.cfdi.WsServiciosService;
import com.icae.model.cfdi.v32.Comprobante;
import com.icae.model.cfdi.v32.Comprobante.Conceptos;
import com.icae.model.cfdi.v32.Comprobante.Conceptos.Concepto;
import com.icae.model.cfdi.v32.Comprobante.Emisor;
import com.icae.model.cfdi.v32.Comprobante.Emisor.RegimenFiscal;
import com.icae.model.cfdi.v32.Comprobante.Impuestos;
import com.icae.model.cfdi.v32.Comprobante.Impuestos.Retenciones;
import com.icae.model.cfdi.v32.Comprobante.Impuestos.Retenciones.Retencion;
import com.icae.model.cfdi.v32.Comprobante.Receptor;
import com.uttec.icae.model.Cliente;
import com.uttec.icae.model.Factura;
import com.uttec.icae.model.FacturaDetalle;
import com.uttec.icae.model.ItemProducto;
import com.uttec.icae.model.Mensaje;
import com.uttec.icae.model.Producto;
import com.uttec.icae.model.Venta;
import com.uttec.icae.service.cliente.ClienteService;
import com.uttec.icae.service.factura.FacturaService;
import com.uttec.icae.service.facturaDetalle.FacturaDetalleService;
import com.uttec.icae.service.producto.ProductoService;
import com.uttec.icae.utils.IcaeErpUtils;

@Controller
@SessionAttributes({ "usuario" })
public class FacturacionController {
	
	private static final Logger logger = LoggerFactory.getLogger(FacturacionController.class);
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private FacturaDetalleService facturaDetalleService;
	
	public String carpetaDefault = "C:\\FACTURA";
	
	File fileXml;

	@RequestMapping("/facturacion/clientes")
	public String listProductos(ModelMap model) {
		logger.debug("Recuperando clientes");
		model.put("clientes", clienteService.findAll());
		return "/facturacion/listClientes";
	}
	
	@RequestMapping("/facturacion/ventas")
	public String ventas(ModelMap model) {
		model.put("facturas", facturaService.findAll());
		return "/facturacion/listFacturas";
	}
		
	@RequestMapping("/facturacion/newCliente")
	public String newProducto (ModelMap model) {
		logger.debug("Alta de nuevo cliente");
		model.put("cliente", new Cliente());
		return "/facturacion/clientesForm";
	}
	
	@RequestMapping(value="/facturacion/saveFactura", method=RequestMethod.POST)
	public @ResponseBody Mensaje saveFactura (@RequestBody Venta venta, final RedirectAttributes redirectAttributes) {
		System.out.println("Recibe venta : " + venta.toString());
		Factura factura = new Factura();
		Cliente cliente = new Cliente();
		cliente.setId(Long.parseLong(venta.getCliente()));
		cliente   = clienteService.findOne(cliente);
		factura.setCliente(cliente);
		factura.setFecha(new Date());
		factura.setIva(venta.getIva());
		factura.setSubtotal(venta.getSubtotal());
		factura.setTotal(venta.getTotal());
		
		
		
		List<FacturaDetalle> facturaDetalles = new ArrayList<FacturaDetalle>();
		facturaService.save(factura);
		
		for(ItemProducto item : venta.getListProductos()){
			FacturaDetalle facturaDetalle  = new FacturaDetalle();
			facturaDetalle.setCantidad(item.getCantidad());
			facturaDetalle.setPrecioVenta(item.getPrecio());
			facturaDetalle.setImporte(item.getImporte());
			facturaDetalle.setId(factura.getId());
			Producto producto = new Producto();
			producto.setId(item.getClave());
			producto = productoService.findOne(producto);
			facturaDetalle.setProducto(producto);
			facturaDetalles.add(facturaDetalle);
		}
		
		facturaDetalleService.save(facturaDetalles);
		
		Comprobante comprobante = crearXmlFactura(factura, facturaDetalles);
		timbrarComprobante(comprobante, factura);
		logger.debug("Recibe venta " + venta.toString());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	
	    Mensaje mensaje =  new  Mensaje();
		mensaje.setCodigo("01");
		mensaje.setMensaje("FACTURA GRABADA CON EL USUARIO : "   + name);
		
		return mensaje;
		
	}
	
//	@RequestMapping(value="/facturacion/creaXml")
//	public String creaXml () {
//		Comprobante comprobante = crearXmlFactura();
//		timbrarComprobante(comprobante);
//		return "redirect:/facturacion/ventas";
//	}
	
	

	@RequestMapping(value="/facturacion/consultaPrecioProducto", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Producto consultaPrecioProducto (@RequestParam("id") String id) {
		System.out.println("Recibe idProducto " + id);
		Producto producto = new Producto();
		producto = productoService.findById(Long.parseLong(id));
		return producto;
		
	}
	
	@RequestMapping("/facturacion/modifyCliente/{id}")
	public String modifyEmployee(ModelMap model, @PathVariable("id") Long id) {
		Cliente cliente = new Cliente(id);
		cliente = clienteService.findOne(cliente);
		model.put("cliente", cliente);
		return "/facturacion/clientesForm";
	}
	
	@RequestMapping("/facturacion/newFactura")
	public String newFactura (ModelMap model) {
		logger.debug("Alta de nueva factura");
		model.put("clientes", clienteService.findAll());
		model.put("productos", productoService.findAll());
		return "/facturacion/venta";
	}
	
	@RequestMapping(value = {"/facturacion/saveCliente"}, method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute Cliente cliente, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		if (cliente.getId() != null) {
			clienteService.update(cliente);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.update", null, null));
		} else {
			clienteService.save(cliente);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.save", null, null));
		}
		return "redirect:/facturacion/clientes";
	}

	
	//FIXME APRTIR DE AQUI MOVER A LA LOGIZA DE NEGOCIO
	
	
	public Comprobante crearXmlFactura(Factura factura, List<FacturaDetalle> facturaDetalles) {
		Comprobante comprobante = new Comprobante();
		comprobante.setVersion("3.2");
		comprobante.setFecha(crearFechaComprobante());
		comprobante.setSello("");
		comprobante.setFormaDePago("99");
		comprobante.setNoCertificado("xxxxxxxxxxxxxxxxxxxx");
		comprobante.setCertificado("");
		comprobante.setSubTotal(new BigDecimal(factura.getSubtotal()).setScale(2, BigDecimal.ROUND_UP));
		comprobante.setTotal(new BigDecimal(factura.getTotal()).setScale(2, BigDecimal.ROUND_UP));
		comprobante.setTipoDeComprobante("ingreso");
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
		receptor.setNombre(factura.getCliente().getNombre() + " " + factura.getCliente().getApellidoPaterno() + " " + factura.getCliente().getApellidoMaterno());
		receptor.setRfc(factura.getCliente().getRfc());
		// AGREGANDO EL RECEPTOR AL COMPROBANTE
		comprobante.setReceptor(receptor);
		
		//CONCEPTOS
		Conceptos conceptos = new Conceptos();
		for (FacturaDetalle facturaDetalle : facturaDetalles){
			Concepto concepto = new Concepto();
			concepto.setCantidad(new BigDecimal(facturaDetalle.getCantidad()).setScale(2, BigDecimal.ROUND_UP));
			concepto.setDescripcion(facturaDetalle.getProducto().getDescripcion());
			concepto.setImporte(new BigDecimal(facturaDetalle.getImporte()).setScale(2, BigDecimal.ROUND_UP));
			concepto.setUnidad("PZA.");
			concepto.setValorUnitario(new BigDecimal(facturaDetalle.getPrecioVenta()).setScale(2, BigDecimal.ROUND_UP));
			conceptos.getConcepto().add(concepto);
			
		}
		
		//AGEGANDO CONCEPTO A CONCEPTOS Y COMPROBANTE
		comprobante.setConceptos(conceptos);
		//RETENCIONES
		Retencion retencion = new Retencion();
		retencion.setImporte(new BigDecimal(factura.getIva()).setScale(2, BigDecimal.ROUND_UP));
		retencion.setImpuesto("IVA");
		//AGREGANDO RETENCION AL COMPROBANTE
		Impuestos impuestos = new Impuestos();
		Retenciones retenciones  = new Retenciones();
		retenciones.getRetencion().add(retencion);
		impuestos.setRetenciones(retenciones);
		comprobante.setImpuestos(impuestos); 
		
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
	
	private void timbrarComprobante(Comprobante comprobante, Factura factura) {
		converComprobanteToFile(comprobante, factura);
		
		timbraXML(fileXml);
	}



	private void converComprobanteToFile(Comprobante comprobante, Factura factura) {
		
		try {
			IcaeErpUtils.getXML(creaNombreXml(comprobante, factura), comprobante);
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

	
	private FileOutputStream creaNombreXml(Comprobante comprobante, Factura factura) {
		FileOutputStream fos = null;
		try {
			fileXml = new File(carpetaDefault  + File.separator + "FACTURA_" + factura.getId() + ".xml"); 
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

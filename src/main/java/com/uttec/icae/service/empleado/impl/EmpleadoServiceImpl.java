package com.uttec.icae.service.empleado.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.empleado.EmpleadoRepository;
import com.uttec.icae.dao.rol.RolRepository;
import com.uttec.icae.dao.usuario.UsuarioRepository;
import com.uttec.icae.model.Empleado;
import com.uttec.icae.model.Rol;
import com.uttec.icae.model.TipoRol;
import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.empleado.EmpleadoService;
import com.uttec.icae.service.encoder.PasswordEncoderService;

@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService, ResourceLoaderAware {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	@Autowired
//	private MailService mailService;
	
	@Autowired
	private PasswordEncoderService passwordEncoderService;
	
	@Autowired
	private MessageSource messageSource;
	
	private ResourceLoader resourceLoader;
	
//	@Value("${mail.subject}")
//	private String subject;
//	
//	@Value("${mail.plantilla.plaintext}")
//	private String namePlainText;
//	
//	@Value("${mail.plantilla.htmltext}")
//	private String nameHtmlText;
	
	@Transactional(readOnly = true)
	@Override
	public Empleado findByRfc(Empleado empleado) {
		logger.debug("Recuperando empleado por RFC");
		return empleadoRepository.findByRfc(empleado.getRfc());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Empleado findByEmail(Empleado empleado) {
		logger.debug("Recuperando empleado por Mail");
		return empleadoRepository.findByEmail(empleado.getEmail());
	}
	
	@Transactional
	@Override
	public void update(Empleado updated) {
		Empleado empleadoForUpdate = empleadoRepository.findOne(updated.getId());
		empleadoForUpdate.getUsuario().setEnabled(updated.getUsuario().getEnabled());
		empleadoForUpdate.getUsuario().setUsername(updated.getRfc());
		usuarioRepository.saveAndFlush(empleadoForUpdate.getUsuario());
		empleadoForUpdate.setRfc(updated.getRfc());
		empleadoForUpdate.setNombre(updated.getNombre());
		empleadoForUpdate.setEmail(updated.getEmail());
		empleadoRepository.saveAndFlush(empleadoForUpdate);
	}
	
	@Transactional
	@Override
	public void updateEmail(Empleado updated) {
		if (!updated.getEmail().isEmpty()) {
			Empleado empleadoForUpdate = empleadoRepository.findOne(updated.getId());
			empleadoForUpdate.setEmail(updated.getEmail());
			empleadoRepository.saveAndFlush(empleadoForUpdate);
		} else {
//			throw new PortalNominaException(messageSource.getMessage("messages.error.empty.updateinfo", null, null));
//			throw new Exception(messageSource.getMessage("messages.error.empty.updateinfo", null, null));
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Empleado> findByUsuarioRolId() {
		Rol rolUsuario = rolRepository.findByRol(TipoRol.USUARIO.getName());
		return empleadoRepository.findByUsuarioRolId(rolUsuario.getId());
	}

	@Transactional
	@Override
	public void save(Empleado empleado) {
		Rol rol = rolRepository.findByRol(TipoRol.USUARIO.getName());
		Usuario usuario = new Usuario();
		usuario.setUsername(empleado.getRfc());
		usuario.setPassword(passwordEncoderService.getPasswordEncoded(empleado.getRfc()));
		usuario.setResetPassword(true);
        usuario.setRol(rol);
		usuario.setEnabled(empleado.getUsuario().getEnabled());
//		usuario.setEmpleado(empleado);
		logger.debug("usuario " + usuario);
		usuarioRepository.save(usuario);
		empleado.setUsuario(usuario);
		empleadoRepository.save(empleado);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Empleado findOne(Empleado empleado) {
		return empleadoRepository.findOne(empleado.getId());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Empleado findByRfcAndEmail(Empleado empleado) {
		return empleadoRepository.findByRfcAndEmail(empleado.getRfc(), empleado.getEmail());
	}
	
//	@Override
//	public void resetPassword(Empleado empleado) {
//
//		String randomPassword = PortalNominaUtils.generateRandomPassword(8);
//		
//		empleado.getUsuario().setResetPassword(true);
//		empleado.getUsuario().setPassword(passwordEncoderService.getPasswordEncoded(randomPassword));
//		
//		usuarioRepository.saveAndFlush(empleado.getUsuario());
//		
//		String htmlPlantilla = null;
//		String textoPlanoPlantilla = null;
//		try {
//		Resource htmlResource = resourceLoader.getResource("classpath:/" + nameHtmlText);
//		Resource plainTextResource = resourceLoader.getResource("classpath:/" + namePlainText);
//		
//		htmlPlantilla = IOUtils.toString(htmlResource.getInputStream(), PortalNominaUtils.encodingUTF8);
//		textoPlanoPlantilla = IOUtils.toString(plainTextResource.getInputStream(), PortalNominaUtils.encodingUTF8);
//		
//		//FIXME Validar si cambiamos por freemarker
//		htmlPlantilla = htmlPlantilla.replace("${newPassword}", randomPassword);
//		htmlPlantilla = htmlPlantilla.replace("${company}", empleado.getEmpresa().getNombre());
//		
//		textoPlanoPlantilla = textoPlanoPlantilla.replace("${newPassword}", randomPassword);
//		
//		//FIXME OVP Cambiar por el metodo que utiliza freemarker para personalizar la nueva contraseña
//		mailService.sendMimeMail(textoPlanoPlantilla, htmlPlantilla, subject, empleado.getEmail());
//		} catch (PortalNominaException ex) {
//			//FIXME OVP Cambiar mensaje para tomarlo de archivo de propiedades
//			logger.error("Ocurrio un error al enviar el correo" + ex);
//		} catch (IOException ex) {
//			//FIXME OVP Cambiar mensaje para tomarlo de archivo de propiedades
//			logger.error("Ocurrio un error al enviar el correo" + ex);
//		} catch (Exception ex) {
//			//FIXME OVP Cambiar mensaje para tomarlo de archivo de propiedades
//			logger.error("Ocurrio un error al enviar el correo" + ex);
//		}
//	}
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public void resetPassword(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}
}

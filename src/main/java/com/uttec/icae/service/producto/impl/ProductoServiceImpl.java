package com.uttec.icae.service.producto.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.producto.ProductoRepository;
import com.uttec.icae.model.Empleado;
import com.uttec.icae.model.Producto;
import com.uttec.icae.model.Rol;
import com.uttec.icae.model.TipoRol;
import com.uttec.icae.model.Usuario;
import com.uttec.icae.service.producto.ProductoService;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService, ResourceLoaderAware {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	private ProductoRepository productoRepository;
	
	private ResourceLoader resourceLoader;
	
	@Transactional(readOnly = true)
	@Override
	public Producto findByClave(Producto producto) {
		logger.debug("Recuperando producto por clave");
		return productoRepository.findByClave(producto.getClave());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Producto findById(Long id) {
		logger.debug("Recuperando producto por id");
		return productoRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Producto> findAll() {
		logger.debug("Recuperando todos los productos");
		return productoRepository.findAll();
	}
	
	
	@Transactional
	@Override
	public void update(Producto updated) {
		Producto productoForUpdate = productoRepository.findOne(updated.getId());
		productoForUpdate.setClave(updated.getClave());
		productoForUpdate.setDescripcion(updated.getDescripcion());
		productoForUpdate.setPresentacion(updated.getPresentacion());
		productoForUpdate.setNoExistencias(updated.getNoExistencias());
		productoForUpdate.setCantMax(updated.getCantMax());
		productoForUpdate.setCantMin(updated.getCantMin());
		productoRepository.saveAndFlush(productoForUpdate);
	}
	
	@Transactional
	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Producto findOne(Producto producto) {
		return productoRepository.findOne(producto.getId());
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
		
	}
}

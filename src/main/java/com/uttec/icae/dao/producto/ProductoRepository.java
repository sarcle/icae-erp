package com.uttec.icae.dao.producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttec.icae.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	List<Producto> findAll();
	
	Producto  findByClave(String clave);
}

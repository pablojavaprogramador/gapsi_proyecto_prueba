package com.gadsi.tienda.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gadsi.tienda.model.Articulo;

public interface ArticuloService extends JpaRepository<Articulo, Integer>{
}

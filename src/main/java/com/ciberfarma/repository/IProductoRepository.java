package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.model.Productos;

public interface IProductoRepository extends JpaRepository<Productos, Integer> {

}

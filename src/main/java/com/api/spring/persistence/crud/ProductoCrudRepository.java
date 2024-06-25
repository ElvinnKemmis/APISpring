package com.api.spring.persistence.crud;

import com.api.spring.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository <Producto, Integer>{

    List<Producto> findByIdCategoriaOrderByNombreAsc(int Categoria);
    Optional<List<Producto>> findByCantidadStockLesstahnAndEstado(int cantidadStock, boolean estado);

}
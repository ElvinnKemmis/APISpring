package com.api.spring.domain.repository;

import com.api.spring.domain.Product;
import com.api.spring.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
//    Definimos als reglas que tendra nuestro dominio cuando se queira usar la BD
    List<Product> getAll();
    Optional<List<Product>> getBYCategory (int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete (int productId);
}

package com.api.spring.persistence;

import com.api.spring.domain.Product;
import com.api.spring.domain.repository.ProductRepository;
import com.api.spring.persistence.crud.ProductoCrudRepository;
import com.api.spring.persistence.entity.Producto;
import com.api.spring.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Con esta notación indicamos que esta clase se encarga de interactuar con la BD
@Repository
public class ProductoRepository implements ProductRepository {

//    Realizamos la inyecciond e dependencias con el Autowired, pero debemos
//    asegurarnos que sea un comente de spring

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;


//    Creando metodos
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getBYCategory(int categoryId) {
        List<Producto> productos =productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLesstahnAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return  productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProduct(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}

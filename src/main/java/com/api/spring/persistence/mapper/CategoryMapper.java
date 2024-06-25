package com.api.spring.persistence.mapper;

import com.api.spring.domain.Category;
import com.api.spring.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
//    diseñamos los conversores o mappers, para trasnformar los atributos
//    de español a ingles en este caso categoria a category
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

//    Con esto spring sabeq eu tiene que acer lo inverso de category a Categoria
//     y tambien le decimos que ignore la conversion de productos
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria (Category category);
}

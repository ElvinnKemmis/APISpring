package com.api.spring.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

//Se crea esta clase para poder emeber luego las llaves compuestas que gneran
//la llave primaria de ComprasProducto
@Embeddable
public class ComprasProductoPK implements Serializable {
    @Column(name="id_compra")
    private Integer idcompra;
    @Column(name="id_producto")
    private Integer idProducto;


    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}

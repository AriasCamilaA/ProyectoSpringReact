package com.api.models;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;

@Entity
@Data
@Table(name = "sabor_has_producto")
public class SaborHasProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idSaborHasProducto;

    @ManyToOne
    @JoinColumn(name = "id_sabor_fk")
    private SaborModel sabor;

    @ManyToOne
    @JoinColumn(name = "id_producto_fk")
    private ProductoModel producto;

    @Column
    private boolean estado;

    public SaborHasProductoModel() {
    }

    public SaborHasProductoModel(Integer idSaborHasProducto, SaborModel sabor, ProductoModel producto, boolean estado) {
        this.idSaborHasProducto = idSaborHasProducto;
        this.sabor = sabor;
        this.producto = producto;
        this.estado = estado;
    }

    public Integer getIdSaborHasProducto() {
        return idSaborHasProducto;
    }

    public void setIdSaborHasProducto(Integer idSaborHasProducto) {
        this.idSaborHasProducto = idSaborHasProducto;
    }

    public SaborModel getSabor() {
        return sabor;
    }

    public void setSabor(SaborModel sabor) {
        this.sabor = sabor;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

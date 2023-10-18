package com.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "inventario")
public class InventarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idInventario;

    @Column
    private int stockInventario;

    @Column
    private String tipoInventario;

    @ManyToOne
    @JoinColumn(name = "id_insumo_fk")
    private InsumoModel insumo;

    @ManyToOne
    @JoinColumn(name = "id_producto_fk")
    private ProductoModel producto;

    @Column
    private boolean estado;

    public InventarioModel() {
    }

    public InventarioModel(Integer idInventario, int stockInventario, String tipoInventario, InsumoModel insumo, ProductoModel producto, boolean estado) {
        this.idInventario = idInventario;
        this.stockInventario = stockInventario;
        this.tipoInventario = tipoInventario;
        this.insumo = insumo;
        this.producto = producto;
        this.estado = estado;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public int getStockInventario() {
        return stockInventario;
    }

    public void setStockInventario(int stockInventario) {
        this.stockInventario = stockInventario;
    }

    public String getTipoInventario() {
        return tipoInventario;
    }

    public void setTipoInventario(String tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    public InsumoModel getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoModel insumo) {
        this.insumo = insumo;
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
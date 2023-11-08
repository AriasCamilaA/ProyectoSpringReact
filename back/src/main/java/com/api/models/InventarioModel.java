package com.api.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "inventario")
public class InventarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idInventario;

    @Column
    private Long stockInventario;

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

    public InventarioModel(Long idInventario, Long stockInventario, String tipoInventario, InsumoModel insumo, ProductoModel producto, boolean estado) {
        this.idInventario = idInventario;
        this.stockInventario = stockInventario;
        this.tipoInventario = tipoInventario;
        this.insumo = insumo;
        this.producto = producto;
        this.estado = estado;
    }

    public Long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }

    public Long getStockInventario() {
        return stockInventario;
    }

    public void setStockInventario(Long stockInventario) {
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
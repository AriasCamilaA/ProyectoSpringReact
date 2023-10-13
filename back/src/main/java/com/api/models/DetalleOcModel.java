package com.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleoc")
public class DetalleOcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idDetalleOc;

    @Column
    private int cantidadInsumo;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra_fk")
    private OrdenCompraModel ordenCompra;

    @ManyToOne
    @JoinColumn(name = "id_insumo_fk")
    private InsumoModel insumo;

    @Column
    private boolean estado;

    public DetalleOcModel() {
    }

    public DetalleOcModel(Integer idDetalleOc, int cantidadInsumo, OrdenCompraModel ordenCompra, InsumoModel insumo, boolean estado) {
        this.idDetalleOc = idDetalleOc;
        this.cantidadInsumo = cantidadInsumo;
        this.ordenCompra = ordenCompra;
        this.insumo = insumo;
        this.estado = estado;
    }

    public Integer getIdDetalleOc() {
        return idDetalleOc;
    }

    public void setIdDetalleOc(Integer idDetalleOc) {
        this.idDetalleOc = idDetalleOc;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public OrdenCompraModel getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraModel ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public InsumoModel getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoModel insumo) {
        this.insumo = insumo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
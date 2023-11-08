package com.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_oc")
public class DetalleOcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idDetalleOc;

    @Column
    private Long cantidadInsumo;

    @ManyToOne
    @JoinColumn(name = "id_oc_fk")
    private OrdenCompraModel ordenCompra;

    @ManyToOne
    @JoinColumn(name = "id_insumo_fk")
    private InsumoModel insumo;

    @Column
    private boolean estado;

    public DetalleOcModel() {
    }

    public DetalleOcModel(Long idDetalleOc, Long cantidadInsumo, OrdenCompraModel ordenCompra, InsumoModel insumo, boolean estado) {
        this.idDetalleOc = idDetalleOc;
        this.cantidadInsumo = cantidadInsumo;
        this.ordenCompra = ordenCompra;
        this.insumo = insumo;
        this.estado = estado;
    }

    public Long getIdDetalleOc() {
        return idDetalleOc;
    }

    public void setIdDetalleOc(Long idDetalleOc) {
        this.idDetalleOc = idDetalleOc;
    }

    public Long getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(Long cantidadInsumo) {
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
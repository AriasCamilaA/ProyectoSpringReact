package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity

@Table(name = "oc_has_proveedor")
public class OcHasProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idOcHasProveedor;

    @ManyToOne
    @JsonIgnoreProperties("ocHasProveedores")
    @JoinColumn(name = "id_proveedor_fk")
    private ProveedorModel proveedor;

    @ManyToOne
    @JsonIgnoreProperties("ocHasProveedores")
    @JoinColumn(name = "id_oc_fk")
    private OrdenCompraModel ordenCompra;

    @Column
    private boolean estado;

    public OcHasProveedorModel() {
    }

    public OcHasProveedorModel(Long idOcHasProveedor, ProveedorModel proveedor, OrdenCompraModel ordenCompra, boolean estado) {
        this.idOcHasProveedor = idOcHasProveedor;
        this.proveedor = proveedor;
        this.ordenCompra = ordenCompra;
        this.estado = estado;
    }

    public Long getIdOcHasProveedor() {
        return idOcHasProveedor;
    }

    public void setIdOcHasProveedor(Long idOcHasProveedor) {
        this.idOcHasProveedor = idOcHasProveedor;
    }

    public ProveedorModel getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorModel proveedor) {
        this.proveedor = proveedor;
    }

    public OrdenCompraModel getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraModel ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
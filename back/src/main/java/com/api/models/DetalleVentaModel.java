package com.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "detalle_venta")
public class DetalleVentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idDetalleVenta;

    @Column
    private Long cantidadProducto;

    @Column
    private Long subtotalDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "id_producto_fk")
    private ProductoModel producto;

    @ManyToOne
    @JoinColumn(name = "id_venta_fk")
    private VentaModel venta;

    @Column
    private boolean estado;

    public DetalleVentaModel() {
    }

    public DetalleVentaModel(Long idDetalleVenta, Long cantidadProducto, Long subtotalDetalleVenta, ProductoModel producto, VentaModel venta, boolean estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidadProducto = cantidadProducto;
        this.subtotalDetalleVenta = subtotalDetalleVenta;
        this.producto = producto;
        this.venta = venta;
        this.estado = estado;
    }

    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Long getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Long cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Long getSubtotalDetalleVenta() {
        return subtotalDetalleVenta;
    }

    public void setSubtotalDetalleVenta(Long subtotalDetalleVenta) {
        this.subtotalDetalleVenta = subtotalDetalleVenta;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public VentaModel getVenta() {
        return venta;
    }

    public void setVenta(VentaModel venta) {
        this.venta = venta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

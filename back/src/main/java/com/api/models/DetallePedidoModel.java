package com.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "detalle_pedido")
public class DetallePedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idDetallePedido;

    @Column
    private Long cantidadProducto;

    @Column
    private Long subtotalDetallePedido;

    @ManyToOne
    @JoinColumn(name = "id_producto_fk")
    private ProductoModel producto;

    @ManyToOne
    @JoinColumn(name = "id_pedido_fk")
    private PedidoModel pedido;

    @Column
    private boolean estado;

    public DetallePedidoModel() {
    }

    public DetallePedidoModel(Long idDetallePedido, Long cantidadProducto, Long subtotalDetallePedido, ProductoModel producto, PedidoModel pedido, boolean estado) {
        this.idDetallePedido = idDetallePedido;
        this.cantidadProducto = cantidadProducto;
        this.subtotalDetallePedido = subtotalDetallePedido;
        this.producto = producto;
        this.pedido = pedido;
        this.estado = estado;
    }

    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Long getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Long cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Long getSubtotalDetallePedido() {
        return subtotalDetallePedido;
    }

    public void setSubtotalDetallePedido(Long subtotalDetallePedido) {
        this.subtotalDetallePedido = subtotalDetallePedido;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

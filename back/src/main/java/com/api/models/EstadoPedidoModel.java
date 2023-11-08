package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estado_pedido")
public class EstadoPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEstadoPedido;

    @Column
    private String nombreEstado;

    @Column
    private boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "estadoPedido")
    private List<PedidoModel> pedidos;

    public EstadoPedidoModel() {
    }

    public EstadoPedidoModel(Long idEstadoPedido, String nombreEstado, boolean estado, List<PedidoModel> pedidos) {
        this.idEstadoPedido = idEstadoPedido;
        this.nombreEstado = nombreEstado;
        this.estado = estado;
        this.pedidos = pedidos;
    }

    public Long getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Long idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<PedidoModel> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoModel> pedidos) {
        this.pedidos = pedidos;
    }
}
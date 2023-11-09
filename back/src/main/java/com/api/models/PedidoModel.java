package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idPedido;

    @Column
    private String descripcionPedido;

    @Column
    private LocalDate fechaPedido;

    @ManyToOne
    @JsonIgnoreProperties("pedidos")
    @JoinColumn(name = "id_estado_pedido_fk")
    private EstadoPedidoModel estadoPedido;

    @ManyToOne
    @JsonIgnoreProperties("pedidos")
    @JoinColumn(name = "no_documento_usuario_fk")
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "pedido")
    @JsonIgnore
    private List<CalificacionModel> calificaciones;

    @OneToMany(mappedBy = "pedido")
    @JsonIgnore
    private List<VentaModel> ventas;

    @Column
    private boolean estado;

    public PedidoModel() {
    }

    public PedidoModel(Long idPedido, String descripcionPedido, LocalDate fechaPedido, EstadoPedidoModel estadoPedido, UsuarioModel usuario, List<CalificacionModel> calificaciones, List<VentaModel> ventas, boolean estado) {
        this.idPedido = idPedido;
        this.descripcionPedido = descripcionPedido;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.usuario = usuario;
        this.calificaciones = calificaciones;
        this.ventas = ventas;
        this.estado = estado;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedidoModel getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedidoModel estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public List<CalificacionModel> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionModel> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<VentaModel> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaModel> ventas) {
        this.ventas = ventas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "venta")
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idVenta;
    
    @Column
    private LocalDate fechaVenta;

    @Column
    private LocalTime horaventa;

    @Column
    private Long totalVenta;

    @ManyToOne
    @JoinColumn(name = "id_pedido_fk")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "no_documento_usuario_fk")
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "venta")
    @JsonIgnore
    private List<DetalleVentaModel> detallesVenta;

    @Column
    private boolean estado;

    public VentaModel() {
    }

    public VentaModel(Integer idVenta, LocalDate fechaVenta, LocalTime horaventa, Long totalVenta, PedidoModel pedido, UsuarioModel usuario, List<DetalleVentaModel> detallesVenta, boolean estado) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.horaventa = horaventa;
        this.totalVenta = totalVenta;
        this.pedido = pedido;
        this.usuario = usuario;
        this.detallesVenta = detallesVenta;
        this.estado = estado;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalTime getHoraventa() {
        return horaventa;
    }

    public void setHoraventa(LocalTime horaventa) {
        this.horaventa = horaventa;
    }

    public Long getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Long totalVenta) {
        this.totalVenta = totalVenta;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public List<DetalleVentaModel> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVentaModel> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

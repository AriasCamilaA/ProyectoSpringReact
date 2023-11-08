package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "venta")
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idVenta;
    
    @Column
    private LocalDate fechaVenta;

    @Column
    private LocalTime horaVenta;

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

    public VentaModel(Long idVenta, LocalDate fechaVenta, LocalTime horaventa, Long totalVenta, PedidoModel pedido, UsuarioModel usuario, List<DetalleVentaModel> detallesVenta, boolean estado) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaventa;
        this.totalVenta = totalVenta;
        this.pedido = pedido;
        this.usuario = usuario;
        this.detallesVenta = detallesVenta;
        this.estado = estado;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalTime getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(LocalTime horaventa) {
        this.horaVenta = horaventa;
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

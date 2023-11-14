package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "calificacion")
public class CalificacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idCalificacion;

    @Column
    private Long estrallasCalificacion;

    @Column
    private String comentarioCalificacion;

    @ManyToOne
    @JsonIgnoreProperties("calificaciones")
    @JoinColumn(name = "id_proveedor_fk")
    private ProveedorModel proveedor;

    @ManyToOne
    @JsonIgnoreProperties("calificaciones")
    @JoinColumn(name = "id_pedido_fk")
    private PedidoModel pedido;

    @Column
    private boolean estado;

    public CalificacionModel() {
    }

//    Constructor para calificación del proveedor
    public CalificacionModel(Long idCalificacion, Long estrallasCalificacion, String comentarioCalificacion, ProveedorModel proveedor) {
        this.idCalificacion = idCalificacion;
        this.estrallasCalificacion = estrallasCalificacion;
        this.comentarioCalificacion = comentarioCalificacion;
        this.proveedor = proveedor;
        this.estado = true;
    }

//    Constructor para calificación del pedido
    public CalificacionModel(Long idCalificacion, Long estrallasCalificacion, String comentarioCalificacion, PedidoModel pedido) {
        this.idCalificacion = idCalificacion;
        this.estrallasCalificacion = estrallasCalificacion;
        this.comentarioCalificacion = comentarioCalificacion;
        this.pedido = pedido;
        this.estado = true;
    }

    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Long getEstrallasCalificacion() {
        return estrallasCalificacion;
    }

    public void setEstrallasCalificacion(Long estrallasCalificacion) {
        this.estrallasCalificacion = estrallasCalificacion;
    }

    public String getComentarioCalificacion() {
        return comentarioCalificacion;
    }

    public void setComentarioCalificacion(String comentarioCalificacion) {
        this.comentarioCalificacion = comentarioCalificacion;
    }

    public ProveedorModel getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorModel proveedor) {
        this.proveedor = proveedor;
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
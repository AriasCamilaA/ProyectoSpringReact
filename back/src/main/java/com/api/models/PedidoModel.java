package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer idPedido;

    @Column
    private String descripcionPedido;

    @Column
    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "id_estado_pedido_fk")
    private EstadoPedidoModel estadoPedido;

    @ManyToOne
    @JoinColumn(name = "no_documento_usuario_fk")
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "pedido")
    @JsonIgnore
    private List<CalificacionModel> calificaciones;

    @OneToMany(mappedBy = "pedido")
    private List<VentaModel> ventas;

    @Column
    private boolean estado;

}
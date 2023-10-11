package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private List<CalificacionModel> calificaciones;

    @OneToMany(mappedBy = "pedido")
    private List<VentaModel> ventas;

    @Column
    private boolean estado;

}
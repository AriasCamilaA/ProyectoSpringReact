package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

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
    private List<DetalleVentaModel> detallesVenta;

    @Column
    private boolean estado;
}

package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private int idVenta;
    
    @Column
    private LocalDate fechaVenta;

    @Column
    private LocalTime horaventa;

    @Column
    private Long totalVenta;

    @Column
    private boolean estado;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido_FK")
    @OrderBy
    private PedidoModel pedido;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venta_FK")
    @OrderBy
    private Set<DetalleVentaModel> detalleVenta;
}

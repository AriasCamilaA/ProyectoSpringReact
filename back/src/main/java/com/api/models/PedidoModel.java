package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
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
    private int idPedido;

    @Column
    private String descripcionPedido;

    @Column
    private LocalDate fechaPedido;

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_calificacion_FK")
    @OrderBy
    private Set<CalificacionModel> calificacion;
}
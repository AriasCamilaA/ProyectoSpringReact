package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estadopedido")
public class EstadoPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idEstadoPedido;

    @Column
    private String nombreEstado;

    @Column
    private boolean estado;

    @OneToMany(mappedBy = "estadoPedido")
    private List<PedidoModel> pedidos;

}
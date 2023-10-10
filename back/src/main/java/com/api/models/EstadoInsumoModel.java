package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "estado_insumo")
public class EstadoInsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idEstadoInsumo;

    @Column
    private String nombreEstadoInsumo;

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado_insumo_FK")
    @OrderBy
    private Set<InsumoModel> insumo;
}
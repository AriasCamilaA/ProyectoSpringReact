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

@Table(name = "estado_insumo")
public class EstadoInsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idEstadoInsumo;

    @Column
    private String nombreEstadoInsumo;

    @OneToMany(mappedBy = "estadoInsumo")
    private List<InsumoModel> insumos;

    @Column
    private boolean estado;

}
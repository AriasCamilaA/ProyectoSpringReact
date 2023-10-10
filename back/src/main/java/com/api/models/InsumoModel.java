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

@Table(name = "insumo")
public class InsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idInsumo;

    @Column
    private String nombreInsumo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_insumo_FK")
    @OrderBy
    private Set<DetalleOcModel> detalleOc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_insumo_FK")
    @OrderBy
    private Set<InventarioModel> inventario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_insumo_FK")
    @OrderBy
    private Set<HistoricoModel> historico;

    @Column
    private boolean estado;
}

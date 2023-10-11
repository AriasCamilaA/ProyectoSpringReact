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

@Table(name = "insumo")
public class InsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idInsumo;

    @Column
    private String nombreInsumo;

    @ManyToOne
    @JoinColumn(name = "id_estado_insumo")
    private EstadoInsumoModel estadoInsumo;

    @OneToMany(mappedBy = "insumo")
    private List<DetalleOcModel> detallesOc;

    @OneToMany(mappedBy = "insumo")
    private List<InventarioModel> inventarios;

    @OneToMany(mappedBy = "insumo")
    private List<HistoricoModel> historicos;

    @Column
    private boolean estado;
}

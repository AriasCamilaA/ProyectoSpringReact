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

@Table(name = "tipo_movimiento")
public class TipoMovimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idTipoMovimiento;

    @Column
    private String nombreTipoMovimiento;

    @Column
    private boolean estado;

    @OneToMany(mappedBy = "tipoMovimiento")
    private List<HistoricoModel> historicos;

}
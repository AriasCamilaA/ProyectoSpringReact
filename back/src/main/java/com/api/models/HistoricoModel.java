package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historico")
public class HistoricoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idHistorico;

    @Column
    private LocalDate fechaMovimiento;

    @Column
    private LocalDate fechaCaducidad;

    @Column
    private int cantidadHistorico;

    @Column
    private String tipoHistorico;

    @Column
    private boolean estado;
}

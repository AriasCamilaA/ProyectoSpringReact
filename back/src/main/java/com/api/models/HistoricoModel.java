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
    private Integer idHistorico;

    @Column
    private LocalDate fechaMovimiento;

    @Column
    private LocalDate fechaCaducidad;

    @Column
    private int cantidadHistorico;

    @Column
    private String tipoHistorico;

    @ManyToOne
    @JoinColumn(name = "id_insumo_fk")
    private InsumoModel insumo;

    @ManyToOne
    @JoinColumn(name = "id_producto_fk")
    private ProductoModel producto;

    @ManyToOne
    @JoinColumn(name = "id_tipo_movimiento_fk")
    private TipoMovimientoModel tipoMovimiento;

    @Column
    private boolean estado;
}

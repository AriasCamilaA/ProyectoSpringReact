package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tipo_movimiento")
public class TipoMovimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idTipoMovimiento;

    @Column
    private String nombreTipoMovimiento;

    @Column
    private boolean estado;

    @OneToMany(mappedBy = "tipoMovimiento")
    @JsonIgnore
    private List<HistoricoModel> historicos;

    public TipoMovimientoModel() {
    }

    public TipoMovimientoModel(Long idTipoMovimiento, String nombreTipoMovimiento, boolean estado, List<HistoricoModel> historicos) {
        this.idTipoMovimiento = idTipoMovimiento;
        this.nombreTipoMovimiento = nombreTipoMovimiento;
        this.estado = estado;
        this.historicos = historicos;
    }

    public Long getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Long idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getNombreTipoMovimiento() {
        return nombreTipoMovimiento;
    }

    public void setNombreTipoMovimiento(String nombreTipoMovimiento) {
        this.nombreTipoMovimiento = nombreTipoMovimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<HistoricoModel> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoModel> historicos) {
        this.historicos = historicos;
    }
}
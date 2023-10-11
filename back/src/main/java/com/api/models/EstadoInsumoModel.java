package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "estado_insumo")
public class EstadoInsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idEstadoInsumo;

    @Column
    private String nombreEstadoInsumo;

    @OneToMany(mappedBy = "estadoInsumo")
    @JsonIgnore
    private List<InsumoModel> insumos;

    @Column
    private boolean estado;

    public EstadoInsumoModel() {
    }

    public EstadoInsumoModel(Integer idEstadoInsumo, String nombreEstadoInsumo, List<InsumoModel> insumos, boolean estado) {
        this.idEstadoInsumo = idEstadoInsumo;
        this.nombreEstadoInsumo = nombreEstadoInsumo;
        this.insumos = insumos;
        this.estado = estado;
    }

    public Integer getIdEstadoInsumo() {
        return idEstadoInsumo;
    }

    public void setIdEstadoInsumo(Integer idEstadoInsumo) {
        this.idEstadoInsumo = idEstadoInsumo;
    }

    public String getNombreEstadoInsumo() {
        return nombreEstadoInsumo;
    }

    public void setNombreEstadoInsumo(String nombreEstadoInsumo) {
        this.nombreEstadoInsumo = nombreEstadoInsumo;
    }

    public List<InsumoModel> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<InsumoModel> insumos) {
        this.insumos = insumos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
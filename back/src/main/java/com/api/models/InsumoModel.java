package com.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "insumo")
public class InsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idInsumo;

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

    public InsumoModel() {
    }

    public InsumoModel(Long idInsumo, String nombreInsumo, EstadoInsumoModel estadoInsumo, List<DetalleOcModel> detallesOc, List<InventarioModel> inventarios, List<HistoricoModel> historicos, boolean estado) {
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
        this.estadoInsumo = estadoInsumo;
        this.detallesOc = detallesOc;
        this.inventarios = inventarios;
        this.historicos = historicos;
        this.estado = estado;
    }

    public Long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public EstadoInsumoModel getEstadoInsumo() {
        return estadoInsumo;
    }

    public void setEstadoInsumo(EstadoInsumoModel estadoInsumo) {
        this.estadoInsumo = estadoInsumo;
    }

    public List<DetalleOcModel> getDetallesOc() {
        return detallesOc;
    }

    public void setDetallesOc(List<DetalleOcModel> detallesOc) {
        this.detallesOc = detallesOc;
    }

    public List<InventarioModel> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<InventarioModel> inventarios) {
        this.inventarios = inventarios;
    }

    public List<HistoricoModel> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoModel> historicos) {
        this.historicos = historicos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

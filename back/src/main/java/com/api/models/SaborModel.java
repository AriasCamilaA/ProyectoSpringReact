package com.api.models;

import jakarta.persistence.*;

import java.util.List;

@Entity

@Table(name = "sabor")
public class SaborModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idSabor;

    @Column
    private String nombreSabor;

    @OneToMany(mappedBy = "sabor")
    private List<SaborHasProductoModel> saborHasProductos;

    @Column
    private boolean estado;

    public SaborModel() {
    }

    public SaborModel(Integer idSabor, String nombreSabor, List<SaborHasProductoModel> saborHasProductos, boolean estado) {
        this.idSabor = idSabor;
        this.nombreSabor = nombreSabor;
        this.saborHasProductos = saborHasProductos;
        this.estado = estado;
    }

    public Integer getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(Integer idSabor) {
        this.idSabor = idSabor;
    }

    public String getNombreSabor() {
        return nombreSabor;
    }

    public void setNombreSabor(String nombreSabor) {
        this.nombreSabor = nombreSabor;
    }

    public List<SaborHasProductoModel> getSaborHasProductos() {
        return saborHasProductos;
    }

    public void setSaborHasProductos(List<SaborHasProductoModel> saborHasProductos) {
        this.saborHasProductos = saborHasProductos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

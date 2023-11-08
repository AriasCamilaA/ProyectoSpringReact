package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "estado_oc")
public class EstadoOcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEstadoOc;

    @Column
    private  String nombreEstadoOc;

    @OneToMany(mappedBy = "estadoOc")
    @JsonIgnore
    private List<OrdenCompraModel> ordenesCompra;

    @Column
    private boolean estado;

    public EstadoOcModel() {
    }

    public EstadoOcModel(Long idEstadoOc, String nombreEstadoOc, List<OrdenCompraModel> ordenesCompra, boolean estado) {
        this.idEstadoOc = idEstadoOc;
        this.nombreEstadoOc = nombreEstadoOc;
        this.ordenesCompra = ordenesCompra;
        this.estado = estado;
    }

    public Long getIdEstadoOc() {
        return idEstadoOc;
    }

    public void setIdEstadoOc(Long idEstadoOc) {
        this.idEstadoOc = idEstadoOc;
    }

    public String getNombreEstadoOc() {
        return nombreEstadoOc;
    }

    public void setNombreEstadoOc(String nombreEstadoOc) {
        this.nombreEstadoOc = nombreEstadoOc;
    }

    public List<OrdenCompraModel> getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(List<OrdenCompraModel> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

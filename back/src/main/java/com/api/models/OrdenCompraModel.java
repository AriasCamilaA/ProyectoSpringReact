package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "orden_compra")
public class OrdenCompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idOc;

    @Column
    private LocalDate fechaOc;

    @ManyToOne
    @JsonIgnoreProperties("ordenesCompra")
    @JoinColumn(name = "id_estado_oc_fk")
    private EstadoOcModel estadoOc;

    @OneToMany(mappedBy = "ordenCompra")
    @JsonIgnore
    private List<DetalleOcModel> detallesOc;

    @OneToMany(mappedBy = "ordenCompra")
    @JsonIgnore
    private List<OcHasProveedorModel> ocHasProveedores;

    @Column
    private boolean estado;

    public OrdenCompraModel() {
    }

    public OrdenCompraModel(Long idOrdenCompra, LocalDate fechaOc, EstadoOcModel estadoOc, List<DetalleOcModel> detallesOc, List<OcHasProveedorModel> ocHasProveedores, boolean estado) {
        this.idOc = idOrdenCompra;
        this.fechaOc = fechaOc;
        this.estadoOc = estadoOc;
        this.detallesOc = detallesOc;
        this.ocHasProveedores = ocHasProveedores;
        this.estado = estado;
    }

    public Long getIdOc() {
        return idOc;
    }

    public void setIdOc(Long idOc) {
        this.idOc = idOc;
    }

    public LocalDate getFechaOc() {
        return fechaOc;
    }

    public void setFechaOc(LocalDate fechaOc) {
        this.fechaOc = fechaOc;
    }

    public EstadoOcModel getEstadoOc() {
        return estadoOc;
    }

    public void setEstadoOc(EstadoOcModel estadoOc) {
        this.estadoOc = estadoOc;
    }

    public List<DetalleOcModel> getDetallesOc() {
        return detallesOc;
    }

    public void setDetallesOc(List<DetalleOcModel> detallesOc) {
        this.detallesOc = detallesOc;
    }

    public List<OcHasProveedorModel> getOcHasProveedores() {
        return ocHasProveedores;
    }

    public void setOcHasProveedores(List<OcHasProveedorModel> ocHasProveedores) {
        this.ocHasProveedores = ocHasProveedores;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

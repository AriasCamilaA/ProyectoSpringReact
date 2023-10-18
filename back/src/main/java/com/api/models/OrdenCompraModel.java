package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer idOrdenCompra;

    @Column
    private LocalDate fechaOC;

    @ManyToOne
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

    public OrdenCompraModel(Integer idOrdenCompra, LocalDate fechaOC, EstadoOcModel estadoOc, List<DetalleOcModel> detallesOc, List<OcHasProveedorModel> ocHasProveedores, boolean estado) {
        this.idOrdenCompra = idOrdenCompra;
        this.fechaOC = fechaOC;
        this.estadoOc = estadoOc;
        this.detallesOc = detallesOc;
        this.ocHasProveedores = ocHasProveedores;
        this.estado = estado;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public LocalDate getFechaOC() {
        return fechaOC;
    }

    public void setFechaOC(LocalDate fechaOC) {
        this.fechaOC = fechaOC;
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

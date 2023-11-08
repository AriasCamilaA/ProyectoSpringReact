package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "proveedor")
public class ProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idProveedor;

    @Column
    private boolean estadoProveedor;

    @Column
    private String empresaProveedor;

    @Column
    private String nombreProveedor;

    @Column
    private String correoProveedor;

    @Column
    private Long nitProveedor;

    @Column
    private Long celularProveedor;

    @Column
    private Long celularRespaldoProveedor;

    @OneToMany(mappedBy = "proveedor")
    @JsonIgnore
    private List<CalificacionModel> calificaciones;

    @OneToMany(mappedBy = "proveedor")
    @JsonIgnore
    private List<OcHasProveedorModel> ocHasProveedores;

    @Column
    private boolean estado;

    public ProveedorModel() {
    }

    public ProveedorModel(Long idProveedor, String empresaProveedor, String nombreProveedor, String correoProveedor, Long nitProveedor, Long celularProveedor, Long celularRespaldoProveedor) {
        this.idProveedor = idProveedor;
        this.empresaProveedor = empresaProveedor;
        this.nombreProveedor = nombreProveedor;
        this.correoProveedor = correoProveedor;
        this.nitProveedor = nitProveedor;
        this.celularProveedor = celularProveedor;
        this.celularRespaldoProveedor = celularRespaldoProveedor;
        this.estadoProveedor = true;
        this.estado = true;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public boolean isEstadoProveedor() {
        return estadoProveedor;
    }

    public void setEstadoProveedor(boolean estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }

    public String getEmpresaProveedor() {
        return empresaProveedor;
    }

    public void setEmpresaProveedor(String empresaProveedor) {
        this.empresaProveedor = empresaProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public Long getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Long getCelularProveedor() {
        return celularProveedor;
    }

    public void setCelularProveedor(Long celularProveedor) {
        this.celularProveedor = celularProveedor;
    }

    public Long getCelularRespaldoProveedor() {
        return celularRespaldoProveedor;
    }

    public void setCelularRespaldoProveedor(Long celularRespaldoProveedor) {
        this.celularRespaldoProveedor = celularRespaldoProveedor;
    }

    public List<CalificacionModel> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionModel> calificaciones) {
        this.calificaciones = calificaciones;
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

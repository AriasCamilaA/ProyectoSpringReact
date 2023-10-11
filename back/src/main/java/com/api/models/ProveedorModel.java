package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "proveedor")
public class ProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idProveedor;

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
    private int celularProveedor;

    @Column
    private int celularRespaldoProveedor;

    @OneToMany(mappedBy = "proveedor")
    private List<CalificacionModel> calificaciones;

    @OneToMany(mappedBy = "proveedor")
    private List<OcHasProveedorModel> ocHasProveedores;

    @Column
    private boolean estado;

    public ProveedorModel() {
    }

    public ProveedorModel(Integer idProveedor, String empresaProveedor, String nombreProveedor, String correoProveedor, Long nitProveedor, int celularProveedor, int celularRespaldoProveedor) {
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

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
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

    public int getCelularProveedor() {
        return celularProveedor;
    }

    public void setCelularProveedor(int celularProveedor) {
        this.celularProveedor = celularProveedor;
    }

    public int getCelularRespaldoProveedor() {
        return celularRespaldoProveedor;
    }

    public void setCelularRespaldoProveedor(int celularRespaldoProveedor) {
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

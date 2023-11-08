package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
@Table(name = "permiso") // Tabla base de datos
public class PermisoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idPermiso;

    @Column
    private String descripcionPermiso;

    @OneToMany(mappedBy = "permiso")
    @JsonIgnore
    private List<RolHasPermisoModel> RolHasPermisos;

    @Column
    private boolean estado;

    public PermisoModel() {
    }

    public PermisoModel(Long idPermiso, String descripcionPermiso, List<RolHasPermisoModel> rolHasPermisos, boolean estado) {
        this.idPermiso = idPermiso;
        this.descripcionPermiso = descripcionPermiso;
        RolHasPermisos = rolHasPermisos;
        this.estado = estado;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

    public List<RolHasPermisoModel> getRolHasPermisos() {
        return RolHasPermisos;
    }

    public void setRolHasPermisos(List<RolHasPermisoModel> rolHasPermisos) {
        RolHasPermisos = rolHasPermisos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
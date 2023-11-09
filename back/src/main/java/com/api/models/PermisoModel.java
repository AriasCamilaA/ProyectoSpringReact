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
    private List<RolHasPermisoModel> rolHasPermisos;


    @Column
    private boolean estado;

    public PermisoModel() {
    }

    public PermisoModel(Long idPermiso, String descripcionPermiso, List<RolHasPermisoModel> rolHasPermisos, boolean estado) {
        this.idPermiso = idPermiso;
        this.descripcionPermiso = descripcionPermiso;
        rolHasPermisos = rolHasPermisos;
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
        return rolHasPermisos;
    }

    public void setRolHasPermisos(List<RolHasPermisoModel> rolHasPermisos) {
        rolHasPermisos = rolHasPermisos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
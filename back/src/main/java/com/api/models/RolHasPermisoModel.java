package com.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "rol_has_permiso")
public class RolHasPermisoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idRolHasPermiso;

    @ManyToOne
    @JoinColumn(name = "id_rol_fk")
    private RolModel rol;

    @ManyToOne
    @JoinColumn(name = "id_permiso_fk")
    private PermisoModel permiso;

    @Column
    private boolean estado;

    public RolHasPermisoModel() {
    }

    public RolHasPermisoModel(Integer idRolHasPermiso, RolModel rol, PermisoModel permiso, boolean estado) {
        this.idRolHasPermiso = idRolHasPermiso;
        this.rol = rol;
        this.permiso = permiso;
        this.estado = estado;
    }

    public Integer getIdRolHasPermiso() {
        return idRolHasPermiso;
    }

    public void setIdRolHasPermiso(Integer idRolHasPermiso) {
        this.idRolHasPermiso = idRolHasPermiso;
    }

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }

    public PermisoModel getPermiso() {
        return permiso;
    }

    public void setPermiso(PermisoModel permiso) {
        this.permiso = permiso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

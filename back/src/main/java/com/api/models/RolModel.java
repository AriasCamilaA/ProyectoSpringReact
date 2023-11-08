package com.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "rol")
public class RolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idRol;

    @Column
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<RolHasPermisoModel> rolHasPermisos;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioModel> usuarios;

    @Column
    private boolean estado;

    public RolModel() {
    }

    public RolModel(Long idRol, String nombreRol, List<RolHasPermisoModel> rolHasPermisos, List<UsuarioModel> usuarios, boolean estado) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.rolHasPermisos = rolHasPermisos;
        this.usuarios = usuarios;
        this.estado = estado;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<RolHasPermisoModel> getRolHasPermisos() {
        return rolHasPermisos;
    }

    public void setRolHasPermisos(List<RolHasPermisoModel> rolHasPermisos) {
        this.rolHasPermisos = rolHasPermisos;
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

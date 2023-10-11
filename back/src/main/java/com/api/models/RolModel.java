package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "rol")
public class RolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idRol;

    @Column
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<RolHasPermisoModel> rolHasPermisos;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioModel> usuarios;

    @Column
    private boolean estado;

}

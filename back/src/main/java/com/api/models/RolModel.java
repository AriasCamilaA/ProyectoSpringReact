package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int idRol;

    @Column
    private String nombreRol;

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol_FK")
    @OrderBy
    private Set<RolHasPermisoModel> rolHasPermiso;
}

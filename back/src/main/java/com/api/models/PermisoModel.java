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

@Table(name = "permiso") // Tabla base de datos
public class PermisoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idPermiso;

    @Column
    private String descripcionPermiso;

    @Column
    private boolean estado;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_permiso_FK")
    @OrderBy
    private Set<RolHasPermisoModel> rolHasPermiso;
}
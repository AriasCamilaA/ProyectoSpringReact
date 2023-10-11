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

@Table(name = "permiso") // Tabla base de datos
public class PermisoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idPermiso;

    @Column
    private String descripcionPermiso;

    @OneToMany(mappedBy = "permiso")
    private List<RolHasPermisoModel> RolHasPermisos;

    @Column
    private boolean estado;
}
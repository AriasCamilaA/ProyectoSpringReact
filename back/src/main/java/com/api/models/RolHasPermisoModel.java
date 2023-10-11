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
}

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

@Table(name = "proveedor")
public class ProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idProveedor;

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

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proveedor_FK")
    @OrderBy
    private Set<CalificacionModel> calificacion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proveedor_FK")
    @OrderBy
    private Set<OcHasProveedorModel> ocHasProveedor;
}

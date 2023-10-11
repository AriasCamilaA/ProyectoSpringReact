package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "proveedor")
public class ProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idProveedor;

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

    @OneToMany(mappedBy = "proveedor")
    private List<CalificacionModel> calificaciones;

    @OneToMany(mappedBy = "proveedor")
    private List<OcHasProveedorModel> ocHasProveedores;

    @Column
    private boolean estado;

}

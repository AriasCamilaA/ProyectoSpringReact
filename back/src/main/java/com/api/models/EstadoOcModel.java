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

@Table(name = "estado_oc")
public class EstadoOcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idEstadoOc;

    @Column
    private  String nombreEstadoOc;

    @OneToMany(mappedBy = "estadoOc")
    private List<OrdenCompraModel> ordenesCompra;

    @Column
    private boolean estado;

}

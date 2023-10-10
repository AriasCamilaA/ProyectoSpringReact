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

@Table(name = "estado_oc")
public class EstadoOcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idEstadoOc;

    @Column
    private  String nombreEstadoOc;

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado_oc_FK")
    @OrderBy
    private Set<OrdenCompraModel> ordenCompra;
}

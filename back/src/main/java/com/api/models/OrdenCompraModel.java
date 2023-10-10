package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "orden_compra")
public class OrdenCompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idOrdenCompra;

    @Column
    private LocalDate fechaOC;

    @Column
    private boolean estado;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_orden_compra_FK")
    @OrderBy
    private Set<DetalleOcModel> detalleOc;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_orden_compra_FK")
    @OrderBy
    private Set<OcHasProveedorModel> ocHasProveedor;
}

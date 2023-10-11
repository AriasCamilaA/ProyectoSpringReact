package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalleoc")
public class DetalleOcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idDetalleOc;

    @Column
    private int cantidadInsumo;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra_fk")
    private OrdenCompraModel ordenCompra;

    @ManyToOne
    @JoinColumn(name = "id_insumo_fk")
    private InsumoModel insumo;

    @Column
    private boolean estado;

}
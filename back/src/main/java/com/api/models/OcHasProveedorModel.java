package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oc_has_proveedor")
public class OcHasProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idOcHasProveedor;

    @ManyToOne
    @JoinColumn(name = "id_proveedor_fk")
    private ProveedorModel proveedor;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra_fk")
    private OrdenCompraModel ordenCompra;

    @Column
    private boolean estado;

}
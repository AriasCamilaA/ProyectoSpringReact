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
@Table(name = "producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idProducto;

    @Column
    private int precioProducto;

    @Column
    private String imagenProducto;

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_FK")
    @OrderBy
    private Set<HistoricoModel> historico;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_FK")
    @OrderBy
    private Set<InventarioModel> inventario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_FK")
    @OrderBy
    private Set<DetalleVentaModel> detalleVenta;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto_FK")
    @OrderBy
    private Set<SaborHasProductoModel> saborHasProducto;
}

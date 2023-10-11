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
@Table(name = "producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idProducto;

    @Column
    private int precioProducto;

    @Column
    private String imagenProducto;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVentaModel> detalleVentas;

    @OneToMany(mappedBy = "producto")
    private List<InventarioModel> inventarios;

    @OneToMany(mappedBy = "producto")
    private List<SaborHasProductoModel> saborHasProductos;

    @OneToMany(mappedBy = "producto")
    private List<HistoricoModel> historicos;

    @ManyToOne
    @JoinColumn(name = "id_categoria_fk")
    private CategoriaModel categoria;

    @Column
    private boolean estado;
}

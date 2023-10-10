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
@Table(name = "categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idCategoria;

    @Column
    private String nombreCategoria;

    @Column
    private String descripcionCategoria;

    @Column
    private boolean estado;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria_FK")
    @OrderBy
    private Set<ProductoModel> producto;
}
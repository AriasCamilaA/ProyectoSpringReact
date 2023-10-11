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
@Table(name = "categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idCategoria;

    @Column
    private String nombreCategoria;

    @Column
    private String descripcionCategoria;

    @Column
    private boolean estado;

    @OneToMany(mappedBy = "categoria")
    private List<ProductoModel> productos;

}
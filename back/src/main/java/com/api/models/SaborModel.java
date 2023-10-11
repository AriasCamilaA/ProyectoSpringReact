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

@Table(name = "sabor")
public class SaborModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idSabor;

    @Column
    private String nombreSabor;

    @OneToMany(mappedBy = "sabor")
    private List<SaborHasProductoModel> saborHasProductos;

    @Column
    private boolean estado;

}

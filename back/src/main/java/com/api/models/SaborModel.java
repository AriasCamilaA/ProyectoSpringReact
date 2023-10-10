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

@Table(name = "sabor")
public class SaborModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idSabor;

    @Column
    private String nombreSabor;

    @Column
    private boolean estado;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sabor_FK")
    @OrderBy
    private Set<SaborHasProductoModel> saborHasProducto;
}

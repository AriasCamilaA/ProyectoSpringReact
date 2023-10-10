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
    private int cantidadInsumo;

    @Column
    private boolean estado;
}
package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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
    private Integer idOrdenCompra;

    @Column
    private LocalDate fechaOC;

    @ManyToOne
    @JoinColumn(name = "id_estado_oc_fk")
    private EstadoOcModel estadoOc;

    @OneToMany(mappedBy = "ordenCompra")
    private List<DetalleOcModel> detallesOc;

    @OneToMany(mappedBy = "ordenCompra")
    private List<OcHasProveedorModel> ocHasProveedores;

    @Column
    private boolean estado;

}

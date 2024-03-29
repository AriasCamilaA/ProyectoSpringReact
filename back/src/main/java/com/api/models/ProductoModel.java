package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idProducto;

    @Column
    private String nombreProducto;

    @Column
    private Long precioProducto;

    @Column
    private String imagenProducto;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<DetalleVentaModel> detalleVentas;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<InventarioModel> inventarios;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<SaborHasProductoModel> saborHasProductos;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<HistoricoModel> historicos;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<DetallePedidoModel> detallesPedido;

    @ManyToOne
    @JsonIgnoreProperties("productos")
    @JoinColumn(name = "id_categoria_fk")
    private CategoriaModel categoria;

    @Column
    private boolean estado;

    public ProductoModel() {
    }

    public ProductoModel(Long idProducto,String nombreProducto, Long precioProducto, String imagenProducto, List<DetalleVentaModel> detalleVentas, List<InventarioModel> inventarios, List<SaborHasProductoModel> saborHasProductos, List<HistoricoModel> historicos, CategoriaModel categoria, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.imagenProducto = imagenProducto;
        this.detalleVentas = detalleVentas;
        this.inventarios = inventarios;
        this.saborHasProductos = saborHasProductos;
        this.historicos = historicos;
        this.categoria = categoria;
        this.estado = estado;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Long precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public List<DetalleVentaModel> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(List<DetalleVentaModel> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    public List<InventarioModel> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<InventarioModel> inventarios) {
        this.inventarios = inventarios;
    }

    public List<SaborHasProductoModel> getSaborHasProductos() {
        return saborHasProductos;
    }

    public void setSaborHasProductos(List<SaborHasProductoModel> saborHasProductos) {
        this.saborHasProductos = saborHasProductos;
    }

    public List<HistoricoModel> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoModel> historicos) {
        this.historicos = historicos;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

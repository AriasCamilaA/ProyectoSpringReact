package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "historico")
public class HistoricoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idHistorico;

    @Column
    private LocalDate fechaMovimiento;

    @Column
    private LocalDate fechaCaducidad;

    @Column
    private Long cantidadHistorico;

    @Column
    private String tipoHistorico;

    @ManyToOne
    @JsonIgnoreProperties("historicos")
    @JoinColumn(name = "id_insumo_fk")
    private InsumoModel insumo;

    @ManyToOne
    @JsonIgnoreProperties("historicos")
    @JoinColumn(name = "id_producto_fk")
    private ProductoModel producto;

    @ManyToOne
    @JsonIgnoreProperties("historicos")
    @JoinColumn(name = "id_tipo_movimiento_fk")
    private TipoMovimientoModel tipoMovimiento;

    @Column
    private boolean estado;

    public HistoricoModel() {
    }

    public HistoricoModel(Long idHistorico, LocalDate fechaMovimiento, LocalDate fechaCaducidad, Long cantidadHistorico, String tipoHistorico, InsumoModel insumo, ProductoModel producto, TipoMovimientoModel tipoMovimiento, boolean estado) {
        this.idHistorico = idHistorico;
        this.fechaMovimiento = fechaMovimiento;
        this.fechaCaducidad = fechaCaducidad;
        this.cantidadHistorico = cantidadHistorico;
        this.tipoHistorico = tipoHistorico;
        this.insumo = insumo;
        this.producto = producto;
        this.tipoMovimiento = tipoMovimiento;
        this.estado = estado;
    }

    public Long getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    public LocalDate getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDate fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Long getCantidadHistorico() {
        return cantidadHistorico;
    }

    public void setCantidadHistorico(Long cantidadHistorico) {
        this.cantidadHistorico = cantidadHistorico;
    }

    public String getTipoHistorico() {
        return tipoHistorico;
    }

    public void setTipoHistorico(String tipoHistorico) {
        this.tipoHistorico = tipoHistorico;
    }

    public InsumoModel getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoModel insumo) {
        this.insumo = insumo;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public TipoMovimientoModel getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimientoModel tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

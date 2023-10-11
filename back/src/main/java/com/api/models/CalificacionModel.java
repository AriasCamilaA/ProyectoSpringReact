package com.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calificacion")
public class CalificacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idCalificacion;

    @Column
    private int estrallasCalificacion;

    @Column
    private String comentarioCalificacion;

    @Column
    private boolean estado;

    public CalificacionModel() {
    }

    public CalificacionModel(Integer idCalificacion, int estrallasCalificacion, String comentarioCalificacion, boolean estado) {
        this.idCalificacion = idCalificacion;
        this.estrallasCalificacion = estrallasCalificacion;
        this.comentarioCalificacion = comentarioCalificacion;
        this.estado = estado;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getEstrallasCalificacion() {
        return estrallasCalificacion;
    }

    public void setEstrallasCalificacion(int estrallasCalificacion) {
        this.estrallasCalificacion = estrallasCalificacion;
    }

    public String getComentarioCalificacion() {
        return comentarioCalificacion;
    }

    public void setComentarioCalificacion(String comentarioCalificacion) {
        this.comentarioCalificacion = comentarioCalificacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
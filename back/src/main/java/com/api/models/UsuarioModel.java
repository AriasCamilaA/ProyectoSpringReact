package com.api.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "usuario")
public class UsuarioModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private Integer noDocumentoUsuario;

   @Column
   private String email;

   @Column
   private String password;

   @Column
   private int celularUsuario;

   @Column
   private String nombreUsuario;

   @Column
   private int apellidoUsuario;

   @ManyToOne
   @JoinColumn(name = "id_rol_fk")
   private RolModel rol;

   @Column
   private boolean estado;

   public UsuarioModel() {
   }

   public UsuarioModel(Integer noDocumentoUsuario, String email, String password, int celularUsuario, String nombreUsuario, int apellidoUsuario, RolModel rol, boolean estado) {
      this.noDocumentoUsuario = noDocumentoUsuario;
      this.email = email;
      this.password = password;
      this.celularUsuario = celularUsuario;
      this.nombreUsuario = nombreUsuario;
      this.apellidoUsuario = apellidoUsuario;
      this.rol = rol;
      this.estado = estado;
   }

   public Integer getNoDocumentoUsuario() {
      return noDocumentoUsuario;
   }

   public void setNoDocumentoUsuario(Integer noDocumentoUsuario) {
      this.noDocumentoUsuario = noDocumentoUsuario;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public int getCelularUsuario() {
      return celularUsuario;
   }

   public void setCelularUsuario(int celularUsuario) {
      this.celularUsuario = celularUsuario;
   }

   public String getNombreUsuario() {
      return nombreUsuario;
   }

   public void setNombreUsuario(String nombreUsuario) {
      this.nombreUsuario = nombreUsuario;
   }

   public int getApellidoUsuario() {
      return apellidoUsuario;
   }

   public void setApellidoUsuario(int apellidoUsuario) {
      this.apellidoUsuario = apellidoUsuario;
   }

   public RolModel getRol() {
      return rol;
   }

   public void setRol(RolModel rol) {
      this.rol = rol;
   }

   public boolean isEstado() {
      return estado;
   }

   public void setEstado(boolean estado) {
      this.estado = estado;
   }
}

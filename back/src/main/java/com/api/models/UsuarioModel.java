package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "usuario")
public class UsuarioModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private Long noDocumentoUsuario;

   @Column
   private String email;

   @Column
   private String password;

   @Column
   private Long celularUsuario;

   @Column
   private String nombreUsuario;

   @Column
   private String apellidoUsuario;

   @JsonIgnore
   @OneToMany(mappedBy = "usuario")
   private List<PedidoModel> pedidos;

   @ManyToOne
   @JsonIgnoreProperties("usuarios")
   @JoinColumn(name = "id_rol_fk")
   private RolModel rol;

   @Column
   private boolean estado;

   public UsuarioModel() {
   }

   public UsuarioModel(Long noDocumentoUsuario, String email, String password, Long celularUsuario, String nombreUsuario, String apellidoUsuario, RolModel rol, boolean estado) {
      this.noDocumentoUsuario = noDocumentoUsuario;
      this.email = email;
      this.password = password;
      this.celularUsuario = celularUsuario;
      this.nombreUsuario = nombreUsuario;
      this.apellidoUsuario = apellidoUsuario;
      this.rol = rol;
      this.estado = estado;
   }

   public Long getNoDocumentoUsuario() {
      return noDocumentoUsuario;
   }

   public void setNoDocumentoUsuario(Long noDocumentoUsuario) {
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

   public Long getCelularUsuario() {
      return celularUsuario;
   }

   public void setCelularUsuario(Long celularUsuario) {
      this.celularUsuario = celularUsuario;
   }

   public String getNombreUsuario() {
      return nombreUsuario;
   }

   public void setNombreUsuario(String nombreUsuario) {
      this.nombreUsuario = nombreUsuario;
   }

   public String getApellidoUsuario() {
      return apellidoUsuario;
   }

   public void setApellidoUsuario(String apellidoUsuario) {
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

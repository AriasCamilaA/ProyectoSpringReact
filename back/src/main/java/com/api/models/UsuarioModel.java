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

}

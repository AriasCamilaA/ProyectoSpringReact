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
   private int noDocumentoUsuario;

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

   @Column
   private boolean estado;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "no_documento_usuario_FK")
   @OrderBy
   private Set<VentaModel> venta;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "no_documento_usuario_FK")
   @OrderBy
   private Set<PedidoModel> pedido;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "no_documento_usuario_FK")
   @OrderBy
   private Set<RolModel> rol;
}

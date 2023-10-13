package com.api.controllers;


import com.api.models.UsuarioModel;
import com.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioModel createUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.createUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioModel getUsuarioById(@PathVariable Integer id){
        return usuarioService.getUsuarioById(id);
    }

    @GetMapping
    public List<UsuarioModel> getAllUsuarioes(){
        return usuarioService.getAllUsuarios();
    }

    @DeleteMapping("/{id}")
    private void deleteUsuarioById(@PathVariable Integer id){
        usuarioService.deleteUsuarioById(id);
    }


}


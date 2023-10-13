package com.api.services;


import com.api.models.UsuarioModel;
import com.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioModel createUsuario(UsuarioModel usuario){
        usuario.setEstado(true);
        return usuarioRepository.save(usuario);
    }
    public UsuarioModel getUsuarioById(Integer id){
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.get();
    }
    public List<UsuarioModel> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    public void deleteUsuarioById(Integer id){
        usuarioRepository.deleteById(id);
    }

}



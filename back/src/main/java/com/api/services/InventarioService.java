package com.api.services;

import com.api.models.InventarioModel;
import com.api.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InventarioService {
    @Autowired
    public InventarioRepository inventarioRepository;

    public InventarioModel createInventario(InventarioModel inventario){
        inventario.setEstado(true);
        return inventarioRepository.save(inventario);
    }

    public InventarioModel getInventarioById(Integer id){
        Optional<InventarioModel> optionalInventario = inventarioRepository.findById(id);
        return optionalInventario.get();
    }

    public List<InventarioModel> getAllInventarios(){
        return inventarioRepository.findAll();
    }

    public void deleteInventarioById(Integer id){
        inventarioRepository.deleteById(id);
    }
}

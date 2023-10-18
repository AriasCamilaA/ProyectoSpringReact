package com.api.services;

import com.api.models.SaborHasProductoModel;
import com.api.repositories.SaborHasProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SaborHasProductoService {
    @Autowired
    public SaborHasProductoRepository saborHasProductoRepository;

    public SaborHasProductoModel createSaborHasProducto(SaborHasProductoModel saborHasProducto){
        return saborHasProductoRepository.save(saborHasProducto);
    }

    public SaborHasProductoModel getSaborHasProductoById(Integer id){
        Optional<SaborHasProductoModel> optionalSaborHasProducto = saborHasProductoRepository.findById(id);
        return optionalSaborHasProducto.get();
    }

    public List<SaborHasProductoModel> getAllSaborHasProductos(){
        return saborHasProductoRepository.findAll();
    }

    public void deleteSaborHasProductoById(Integer id){
        saborHasProductoRepository.deleteById(id);
    }
}

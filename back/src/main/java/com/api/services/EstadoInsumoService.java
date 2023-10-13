package com.api.services;


import com.api.models.EstadoInsumoModel;
import com.api.repositories.EstadoInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoInsumoService {
    @Autowired
    private EstadoInsumoRepository estadoInsumoRepository;
    public EstadoInsumoModel createEstadoInsumo(EstadoInsumoModel estadoInsumo){
        estadoInsumo.setEstado(true);
        return estadoInsumoRepository.save(estadoInsumo);
    }
    public EstadoInsumoModel getEstadoInsumoById(Integer id){
        Optional<EstadoInsumoModel> optionalEstadoInsumo = estadoInsumoRepository.findById(id);
        return optionalEstadoInsumo.get();
    }
    public List<EstadoInsumoModel> getAllEstadoInsumos(){
        return estadoInsumoRepository.findAll();
    }
    public void deleteEstadoInsumoById(Integer id){
        estadoInsumoRepository.deleteById(id);
    }

}


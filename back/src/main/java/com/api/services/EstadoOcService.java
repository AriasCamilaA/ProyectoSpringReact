package com.api.services;

import com.api.models.EstadoOcModel;
import com.api.repositories.EstadoOcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoOcService {
    @Autowired
    public EstadoOcRepository estadoOcRepository;
    public EstadoOcModel createEstadoOc(EstadoOcModel estadoOc){
        estadoOc.setEstado(true);
        return estadoOcRepository.save(estadoOc);
    }

    public EstadoOcModel getEstadoOcById(Integer id){
        Optional<EstadoOcModel> optionalEstadoOc = estadoOcRepository.findById(id);
        return optionalEstadoOc.get();
    }

    public List<EstadoOcModel> getAllEstadosOc(){
        return estadoOcRepository.findAll();
    }

    public void deleteEstadoOcById(Integer id){
        estadoOcRepository.deleteById(id);
    }
}

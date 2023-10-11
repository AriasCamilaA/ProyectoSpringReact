package com.api.services;


import com.api.models.InsumoModel;
import com.api.repositories.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;
    public InsumoModel createInsumo(InsumoModel insumo){
        insumo.setEstado(true);
        return insumoRepository.save(insumo);
    }
    public InsumoModel getInsumoById(Integer id){
        Optional<InsumoModel> optionalInsumo = insumoRepository.findById(id);
        return optionalInsumo.get();
    }
    public List<InsumoModel> getAllInsumos(){
        return insumoRepository.findAll();
    }
    public void deleteInsumoById(Integer id){
        insumoRepository.deleteById(id);
    }

}


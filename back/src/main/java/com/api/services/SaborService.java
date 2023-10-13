package com.api.services;

import com.api.models.SaborModel;
import com.api.repositories.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SaborService {

    @Autowired
    public SaborRepository saborRepository;

    public SaborModel createSabor(SaborModel sabor) {
        sabor.setEstado(true);
        return saborRepository.save(sabor);
    }

    public SaborModel getSaborById(Integer id) {
        Optional<SaborModel> optionalSabor = saborRepository.findById(id);
        return optionalSabor.get();
    }

    public List<SaborModel> getAllSabores(){
        return saborRepository.findAll();
    }

    public void deleteSabor(Integer id) {
        saborRepository.deleteById(id);
    }
}
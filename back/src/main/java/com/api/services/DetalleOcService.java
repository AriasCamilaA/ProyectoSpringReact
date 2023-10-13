package com.api.services;

import com.api.models.DetalleOcModel;
import com.api.repositories.DetalleOcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetalleOcService {

    @Autowired
    public DetalleOcRepository detalleOcRepository;

    public DetalleOcModel createDetalleOc(DetalleOcModel detalleOc) {
        detalleOc.setEstado(true);
        return detalleOcRepository.save(detalleOc);
    }

    public DetalleOcModel getDetalleOcById(Integer id) {
        Optional<DetalleOcModel> optionalDetalleOc = detalleOcRepository.findById(id);
        return optionalDetalleOc.get();
    }

    public List<DetalleOcModel> getAllDetallesOc(){
        return detalleOcRepository.findAll();
    }

    public void deleteDetalleOcById(Integer id) {
        detalleOcRepository.deleteById(id);
    }
}

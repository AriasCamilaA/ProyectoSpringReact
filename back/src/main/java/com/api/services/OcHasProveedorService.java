package com.api.services;

import com.api.models.OcHasProveedorModel;
import com.api.repositories.OcHasProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OcHasProveedorService {

    @Autowired
    public OcHasProveedorRepository ocHasProveedorRepository;

    public OcHasProveedorModel createOcHasProveedor(OcHasProveedorModel ocHasProveedor) {
        ocHasProveedor.setEstado(true);
        return ocHasProveedorRepository.save(ocHasProveedor);
    }

    public OcHasProveedorModel getOcHasProveedorById(Integer id) {
        Optional<OcHasProveedorModel> optionalOcHasProveedor = ocHasProveedorRepository.findById(id);
        return optionalOcHasProveedor.get();
    }

    public List<OcHasProveedorModel> getAllOcHasProveedores(){
        return ocHasProveedorRepository.findAll();
    }

    public void deleteOcHasProveedorById(Integer id){
        ocHasProveedorRepository.deleteById(id);
    }
}
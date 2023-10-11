package com.api.services;

import com.api.models.ProveedorModel;
import com.api.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    public ProveedorModel createProveedor(ProveedorModel proveedor){
        proveedor.setEstadoProveedor(true);
        proveedor.setEstado(true);
        return proveedorRepository.save(proveedor);
    }
    public ProveedorModel getProveedorById(Integer id){
        Optional<ProveedorModel> optionalProveedor = proveedorRepository.findById(id);
        return optionalProveedor.get();
    }
    public List<ProveedorModel> getAllProveedores(){
        return proveedorRepository.findAll();
    }
    public void deleteProveedorById(Integer id){
        proveedorRepository.deleteById(id);
    }

}

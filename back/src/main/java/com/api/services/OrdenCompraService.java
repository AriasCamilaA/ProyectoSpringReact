package com.api.services;

import com.api.models.OrdenCompraModel;
import com.api.repositories.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrdenCompraService {
    @Autowired
    public OrdenCompraRepository ordenCompraRepository;

    public OrdenCompraModel createOrdenCompra(OrdenCompraModel ordenCompra){
        ordenCompra.setEstado(true);
        return ordenCompraRepository.save(ordenCompra);
    }

    public OrdenCompraModel getOrdenCompraById(Integer id){
        Optional<OrdenCompraModel> optionalOrdenCompra = ordenCompraRepository.findById(id);
        return optionalOrdenCompra.get();
    }

    public List<OrdenCompraModel> getAllOrdenCompras(){
        return ordenCompraRepository.findAll();
    }

    public void deleteOrdenCompraById(Integer id){
        ordenCompraRepository.deleteById(id);
    }
}

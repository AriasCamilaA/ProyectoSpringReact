package com.api.services;

import com.api.models.DetalleVentaModel;
import com.api.repositories.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetalleVentaService {
    @Autowired
    public DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaModel createDetalleVenta(DetalleVentaModel detalleVenta){
        detalleVenta.setEstado(true);
        return detalleVentaRepository.save(detalleVenta);
    }

    public DetalleVentaModel getDetalleVentaById(Integer id){
        Optional<DetalleVentaModel> optionalDetalleVenta = detalleVentaRepository.findById(id);
        return optionalDetalleVenta.get();
    }

    public List<DetalleVentaModel> getAllDetalleVentas(){
        return detalleVentaRepository.findAll();
    }

    public void deleteDetalleVentaById(Integer id){
        detalleVentaRepository.deleteById(id);
    }
}

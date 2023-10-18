package com.api.services;

import com.api.models.VentaModel;
import com.api.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VentaService {
    @Autowired
    public VentaRepository ventaRepository;

    public VentaModel createVenta(VentaModel venta){
        return ventaRepository.save(venta);
    }

    public VentaModel getVentaById(Integer id){
        Optional<VentaModel> optionalVenta = ventaRepository.findById(id);
        return optionalVenta.get();
    }

    public List<VentaModel> getAllVentas(){
        return ventaRepository.findAll();
    }

    public void deleteVentaById(Integer id){
        ventaRepository.deleteById(id);
    }
}

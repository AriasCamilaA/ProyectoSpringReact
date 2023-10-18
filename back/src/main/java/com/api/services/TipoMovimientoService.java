package com.api.services;

import com.api.models.TipoMovimientoModel;
import com.api.repositories.TipoMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TipoMovimientoService {
    @Autowired
    public TipoMovimientoRepository tipoMovimientoRepository;

    public TipoMovimientoModel createTipoMovimiento(TipoMovimientoModel tipoMovimiento){
        tipoMovimiento.setEstado(true);
        return tipoMovimientoRepository.save(tipoMovimiento);
    }

    public TipoMovimientoModel getTipoMovimientoById(Integer id){
        Optional<TipoMovimientoModel> optionalTipoMovimiento = tipoMovimientoRepository.findById(id);
        return optionalTipoMovimiento.get();
    }

    public List<TipoMovimientoModel> getAllTipoMovimientos(){
        return tipoMovimientoRepository.findAll();
    }

    public void deleteTipoMovimientoById(Integer id){
        tipoMovimientoRepository.deleteById(id);
    }
}

package com.api.controllers;

import com.api.models.TipoMovimientoModel;
import com.api.services.TipoMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tipomovimientos")
public class TipoMovimientoController {
    @Autowired
    private TipoMovimientoService tipoMovimientoService;

    @PostMapping
    public TipoMovimientoModel createTipoMovimiento(@RequestBody TipoMovimientoModel tipoMovimiento){
        return tipoMovimientoService.createTipoMovimiento(tipoMovimiento);
    }

    @GetMapping("/{id}")
    public TipoMovimientoModel getRipoMovimientoById(@PathVariable Integer id){
        return tipoMovimientoService.getTipoMovimientoById(id);
    }

    @GetMapping
    public List<TipoMovimientoModel> getAllTipoMovimientos(){
        return tipoMovimientoService.getAllTipoMovimientos();
    }

    @DeleteMapping("/{id}")
    private void deleteTipoMovimientoById(@PathVariable Integer id){
        tipoMovimientoService.deleteTipoMovimientoById(id);
    }
}

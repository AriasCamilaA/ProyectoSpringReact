package com.api.controllers;

import com.api.models.EstadoInsumoModel;
import com.api.services.EstadoInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estadoInsumos")
public class EstadoInsumoController {
    @Autowired
    private EstadoInsumoService estadoInsumoService;

    @PostMapping
    public EstadoInsumoModel createEstadoInsumo(@RequestBody EstadoInsumoModel estadoInsumo){
        return estadoInsumoService.createEstadoInsumo(estadoInsumo);
    }

    @GetMapping("/{id}")
    public EstadoInsumoModel getEstadoInsumoById(@PathVariable Integer id){
        return estadoInsumoService.getEstadoInsumoById(id);
    }

    @GetMapping
    public List<EstadoInsumoModel> getAllEstadoInsumoes(){
        return estadoInsumoService.getAllEstadoInsumos();
    }

    @DeleteMapping("/{id}")
    private void deleteEstadoInsumoById(@PathVariable Integer id){
        estadoInsumoService.deleteEstadoInsumoById(id);
    }


}

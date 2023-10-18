package com.api.controllers;

import com.api.models.EstadoOcModel;
import com.api.services.EstadoOcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estadosoc")
public class EstadoOcController {
    @Autowired
    private EstadoOcService estadoOcService;

    @PostMapping
    public EstadoOcModel createEstadoOc(@RequestBody EstadoOcModel estadoOc){
        return estadoOcService.createEstadoOc(estadoOc);
    }

    @GetMapping("/{id}")
    public EstadoOcModel getEstadoOcById(@PathVariable Integer id){
        return estadoOcService.getEstadoOcById(id);
    }

    @GetMapping
    public List<EstadoOcModel> getAllEstadosOc(){
        return estadoOcService.getAllEstadosOc();
    }

    @DeleteMapping("/{id}")
    private void deleteEstadoOcById(@PathVariable Integer id){
        estadoOcService.deleteEstadoOcById(id);
    }
}

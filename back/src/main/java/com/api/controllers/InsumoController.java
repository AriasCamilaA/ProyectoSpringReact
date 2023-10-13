package com.api.controllers;


import com.api.models.InsumoModel;
import com.api.services.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/insumos")
public class InsumoController {
    @Autowired
    private InsumoService insumoService;

    @PostMapping
    public InsumoModel createInsumo(@RequestBody InsumoModel insumo){
        return insumoService.createInsumo(insumo);
    }

    @GetMapping("/{id}")
    public InsumoModel getInsumoById(@PathVariable Integer id){
        return insumoService.getInsumoById(id);
    }

    @GetMapping
    public List<InsumoModel> getAllInsumoes(){
        return insumoService.getAllInsumos();
    }

    @DeleteMapping("/{id}")
    private void deleteInsumoById(@PathVariable Integer id){
        insumoService.deleteInsumoById(id);
    }


}

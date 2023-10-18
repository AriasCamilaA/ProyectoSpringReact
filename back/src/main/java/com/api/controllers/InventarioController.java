package com.api.controllers;

import com.api.models.InventarioModel;
import com.api.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventarios")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public InventarioModel createInventario(@RequestBody InventarioModel inventario){
        return inventarioService.createInventario(inventario);
    }

    @GetMapping("/{id}")
    public InventarioModel getInventarioById(@PathVariable Integer id){
        return inventarioService.getInventarioById(id);
    }

    @GetMapping
    public List<InventarioModel> getAllInventarios(){
        return inventarioService.getAllInventarios();
    }

    @DeleteMapping("/{id}")
    private void deleteInventarioById(@PathVariable Integer id){
        inventarioService.deleteInventarioById(id);
    }
}

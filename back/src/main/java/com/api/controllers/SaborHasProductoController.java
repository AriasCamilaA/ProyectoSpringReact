package com.api.controllers;

import com.api.models.SaborHasProductoModel;
import com.api.services.SaborHasProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/saborhasproductos")
public class SaborHasProductoController {
    @Autowired
    private SaborHasProductoService saborHasProductoService;

    @PostMapping
    public SaborHasProductoModel crearSaborHasProducto(@RequestBody SaborHasProductoModel saborHasProducto){
        return saborHasProductoService.createSaborHasProducto(saborHasProducto);
    }

    @GetMapping("/{id}")
    public SaborHasProductoModel getSaborHasProductoById(@PathVariable Integer id){
        return saborHasProductoService.getSaborHasProductoById(id);
    }

    @GetMapping
    public List<SaborHasProductoModel> getAllPermisoHasProductos(){
        return saborHasProductoService.getAllSaborHasProductos();
    }

    @DeleteMapping("/{id}")
    private void deleteSaborHasProductoById(@PathVariable Integer id){
        saborHasProductoService.deleteSaborHasProductoById(id);
    }
}

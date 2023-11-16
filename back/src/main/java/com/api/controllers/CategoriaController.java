package com.api.controllers;

import com.api.models.CategoriaModel;
import com.api.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public CategoriaModel createCategoria(@RequestBody CategoriaModel categoria){
        return categoriaService.createCategoria(categoria);
    }

    @GetMapping("/{id}")
    public CategoriaModel getCategoriaById(@PathVariable Integer id){
        return categoriaService.getCategoriaById(id);
    }

    @GetMapping
    public List<CategoriaModel> getAllCategorias(){
        return categoriaService.getAllCategoria();
    }

    @DeleteMapping("/{id}")
    private void deleteCategoriaById(@PathVariable Integer id){
        categoriaService.deleteCategoriaById(id);
    }
}

package com.api.controllers;

import com.api.models.SaborModel;
import com.api.services.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sabores")
public class SaborController {

    @Autowired
    private SaborService saborService;

    @PostMapping
    public SaborModel createSabor(@RequestBody SaborModel sabor) {
        return saborService.createSabor(sabor);
    }

    @GetMapping("/{id}")
    public SaborModel getSaborById(@PathVariable Integer id) {
        return saborService.getSaborById(id);
    }

    @GetMapping
    public List<SaborModel> getAllSabores() {
        return saborService.getAllSabores();
    }

    @DeleteMapping("/{id}")
    private void deleteSaborById(Integer id) {
    }
}

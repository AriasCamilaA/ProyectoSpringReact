package com.api.controllers;

import com.api.models.PermisoModel;
import com.api.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/permisos")
public class PermisoController {
    @Autowired
    private PermisoService permisoService;

    @PostMapping
    public PermisoModel createPermiso(@RequestBody PermisoModel permiso){
        return permisoService.createPermiso(permiso);
    }

    @GetMapping("/{id}")
    public PermisoModel getPermisoById(@PathVariable Integer id){
        return permisoService.getPermisoById(id);
    }

    @GetMapping
    public List<PermisoModel> getAllPermisos(){
        return permisoService.getAllPermisos();
    }

    @DeleteMapping("/{id}")
    private void deletePermisoById(@PathVariable Integer id){
        permisoService.deletePermisoById(id);
    }
}

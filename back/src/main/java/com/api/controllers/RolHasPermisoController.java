package com.api.controllers;

import com.api.models.RolHasPermisoModel;
import com.api.services.RolHasPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rolhaspermisos")
public class RolHasPermisoController {
    @Autowired
    private RolHasPermisoService rolHasPermisoService;

    @PostMapping
    public RolHasPermisoModel createRolHasPermiso(@RequestBody RolHasPermisoModel rolHasPermiso){
        return rolHasPermisoService.createRolHasPermiso(rolHasPermiso);
    }

    @GetMapping("/{id}")
    public RolHasPermisoModel getRolHasPermisoById(@PathVariable Integer id){
        return rolHasPermisoService.getRolHasPermisoById(id);
    }

    @GetMapping
    public List<RolHasPermisoModel> getAllRolHasPermisos(){
        return rolHasPermisoService.getAllRolHasPermisos();
    }

    @DeleteMapping("/{id}")
    private void deleteRolHasPermisoById(@PathVariable Integer id){
        rolHasPermisoService.deleteRolHasPermisoById(id);
    }

}

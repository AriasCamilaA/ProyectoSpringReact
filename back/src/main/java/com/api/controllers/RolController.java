package com.api.controllers;

import com.api.models.RolModel;
import com.api.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @PostMapping
    public RolModel createRol(@RequestBody RolModel rol){
        return rolService.createRol(rol);
    }

    @GetMapping("/{id}")
    public RolModel getRolById(@PathVariable Integer id){
        return rolService.getRolById(id);
    }

    @GetMapping
    public List<RolModel> getAllRoles(){
        return rolService.getAllRoles();
    }

    @DeleteMapping("/{id}")
    private void deleteRolById(@PathVariable Integer id){
        rolService.deleteRolById(id);
    }


}

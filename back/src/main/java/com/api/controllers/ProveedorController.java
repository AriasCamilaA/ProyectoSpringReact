package com.api.controllers;

import com.api.models.ProveedorModel;
import com.api.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ProveedorModel createProveedor(@RequestBody ProveedorModel proveedor){
        return proveedorService.createProveedor(proveedor);
    }

    @GetMapping("/{id}")
    public ProveedorModel getProveedorById(@PathVariable Integer id){
        return proveedorService.getProveedorById(id);
    }

    @GetMapping
    public List<ProveedorModel> getAllProveedores(){
        return proveedorService.getAllProveedores();
    }

    @DeleteMapping("/{id}")
    private void deleteProveedorById(@PathVariable Integer id){
        proveedorService.deleteProveedorById(id);
    }


}

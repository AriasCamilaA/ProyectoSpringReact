package com.api.controllers;

import com.api.models.OcHasProveedorModel;
import com.api.services.OcHasProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ochasproveedores")
public class OcHasProveedorController {

    @Autowired
    private OcHasProveedorService ocHasProveedorService;

    @PostMapping
    public OcHasProveedorModel createOcHasProveedor(@RequestBody OcHasProveedorModel ocHasProveedor){
        return ocHasProveedorService.createOcHasProveedor(ocHasProveedor);
    }

    @GetMapping("/{id}")
    public OcHasProveedorModel getOcHasProveedorById(@PathVariable Integer id){
        return ocHasProveedorService.getOcHasProveedorById(id);
    }

    @GetMapping
    public List<OcHasProveedorModel> getAllOcHasProveedores(){
        return ocHasProveedorService.getAllOcHasProveedores();
    }

    @DeleteMapping("/{id}")
    private void deleteOcHasProveedorById(Integer id){
        ocHasProveedorService.deleteOcHasProveedorById(id);
    }
}

package com.api.controllers;

import com.api.models.OrdenCompraModel;
import com.api.services.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ordencompras")
public class OrdenCompraController {
    @Autowired
    private OrdenCompraService ordenCompraService;

    @PostMapping
    public OrdenCompraModel createOrdenCompra(@RequestBody OrdenCompraModel ordenCompra){
        return ordenCompraService.createOrdenCompra(ordenCompra);
    }

    @GetMapping("/{id}")
    public OrdenCompraModel getOrdenCompraById(@PathVariable Integer id){
        return ordenCompraService.getOrdenCompraById(id);
    }

    @GetMapping
    public List<OrdenCompraModel> getAllOrdenCompras(){
        return ordenCompraService.getAllOrdenCompras();
    }

    @DeleteMapping("/{id}")
    private void deleteOrdenCompraById(@PathVariable Integer id){
        ordenCompraService.deleteOrdenCompraById(id);
    }
}

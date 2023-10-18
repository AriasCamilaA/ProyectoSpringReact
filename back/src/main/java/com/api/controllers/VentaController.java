package com.api.controllers;

import com.api.models.VentaModel;
import com.api.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping
    public VentaModel createVenta (@RequestBody VentaModel venta){
        return ventaService.createVenta(venta);
    }

    @GetMapping("/{id}")
    public VentaModel getVentaById(@PathVariable Integer id){
        return ventaService.getVentaById(id);
    }

    @GetMapping
    public List<VentaModel> getAllVentas(){
        return ventaService.getAllVentas();
    }

    @DeleteMapping("/{id}")
    private void deleteVentaById(@PathVariable Integer id){
        ventaService.deleteVentaById(id);
    }
}

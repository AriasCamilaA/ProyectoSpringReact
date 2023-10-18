package com.api.controllers;

import com.api.models.DetalleVentaModel;
import com.api.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detalleventas")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping
    public DetalleVentaModel createDetalleVenta(@RequestBody DetalleVentaModel detalleVenta){
        return detalleVentaService.createDetalleVenta(detalleVenta);
    }

    @GetMapping("/{id}")
    public DetalleVentaModel getDetalleVentaById(@PathVariable Integer id){
        return detalleVentaService.getDetalleVentaById(id);
    }

    @GetMapping
    public List<DetalleVentaModel> getAllDetalleVenta(){
        return detalleVentaService.getAllDetalleVentas();
    }

    @DeleteMapping("/{id}")
    private void deleteDetalleVentaById(@PathVariable Integer id){
        detalleVentaService.deleteDetalleVentaById(id);
    }
}

package com.api.controllers;

import com.api.models.DetalleOcModel;
import com.api.services.DetalleOcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detallesoc")
public class DetalleOcController {

    @Autowired
    private DetalleOcService detalleOcService;

    @PostMapping
    public DetalleOcModel createDetalleOc(@RequestBody DetalleOcModel detalleOc) {
        return detalleOcService.createDetalleOc(detalleOc);
    }

    @GetMapping("/{id}")
    public DetalleOcModel getDetalleOcById(@PathVariable Integer id) {
        return detalleOcService.getDetalleOcById(id);
    }

    @GetMapping
    public List<DetalleOcModel> getAllDetallesOc() {
        return detalleOcService.getAllDetallesOc();
    }

    @DeleteMapping("/{id}")
    private void deleteDetalleOc(@PathVariable Integer id) {
        detalleOcService.deleteDetalleOcById(id);
    }
}

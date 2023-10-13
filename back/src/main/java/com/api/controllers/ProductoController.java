package com.api.controllers;

import com.api.models.ProductoModel;
import com.api.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ProductoModel createProducto(@RequestBody ProductoModel productoModel) {
        return productoService.createProducto(productoModel);
    }

    @GetMapping("/{id}")
    public ProductoModel getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @GetMapping
    public List<ProductoModel> getAllProductos() {
        return productoService.getAllProductos();
    }

    @DeleteMapping
    private void deleteProducto(Integer id) {
        productoService.deleteProductoById(id);
    }
}

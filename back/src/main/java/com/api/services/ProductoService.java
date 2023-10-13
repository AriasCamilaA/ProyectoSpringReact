package com.api.services;

import com.api.models.ProductoModel;
import com.api.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProductoService {

    @Autowired
    public ProductoRepository productoRepository;

    public ProductoModel createProducto(ProductoModel producto) {
        producto.setEstado(true);
        return productoRepository.save(producto);
    }

    public ProductoModel getProductoById(Integer id) {
        Optional<ProductoModel> optionalProducto = productoRepository.findById(id);
        return optionalProducto.get();
    }

    public List<ProductoModel> getAllProductos() {
        return productoRepository.findAll();
    }

    public void deleteProductoById(Integer id) {
        productoRepository.deleteById(id);
    }
}
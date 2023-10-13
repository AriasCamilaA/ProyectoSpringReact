package com.api.controllers;

import com.api.models.EstadoPedidoModel;
import com.api.services.EstadoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estadopedidos")
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoService estadoPedidoService;

    @PostMapping
    public EstadoPedidoModel createEstadoPedido(@RequestBody EstadoPedidoModel estadoPedido){
        return estadoPedidoService.createEstadoPedido(estadoPedido);
    }

    @GetMapping("/{id}")
    public EstadoPedidoModel getEstadoPedidoById(@PathVariable Integer id) {
        return estadoPedidoService.getEstadoPedidoById(id);
    }

    @GetMapping
    public List<EstadoPedidoModel> getAllEstadoPedidos() {
        return estadoPedidoService.getAllEstadoPedidos();
    }

    @DeleteMapping("/id")
    private void deleteEstadoPedidoById(Integer id) {
        estadoPedidoService.deleteEstadoPedidoById(id);
    }
}
package com.api.controllers;


import com.api.models.PedidoModel;
import com.api.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoModel createPedido(@RequestBody PedidoModel pedido){
        return pedidoService.createPedido(pedido);
    }

    @GetMapping("/{id}")
    public PedidoModel getPedidoById(@PathVariable Integer id){
        return pedidoService.getPedidoById(id);
    }

    @GetMapping
    public List<PedidoModel> getAllPedidoes(){
        return pedidoService.getAllPedidos();
    }

    @DeleteMapping("/{id}")
    private void deletePedidoById(@PathVariable Integer id){
        pedidoService.deletePedidoById(id);
    }


}


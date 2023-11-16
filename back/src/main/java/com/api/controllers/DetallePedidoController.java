package com.api.controllers;

import com.api.models.DetallePedidoModel;
import com.api.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detallePedidos")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping
    public DetallePedidoModel createDetallePedido(@RequestBody DetallePedidoModel detallePedido){
        return detallePedidoService.createDetallePedido(detallePedido);
    }

    @GetMapping("/{id}")
    public DetallePedidoModel getDetallePedidoById(@PathVariable Integer id){
        return detallePedidoService.getDetallePedidoById(id);
    }

    @GetMapping
    public List<DetallePedidoModel> getAllDetallePedido(){
        return detallePedidoService.getAllDetallePedidos();
    }

    @DeleteMapping("/{id}")
    private void deleteDetallePedidoById(@PathVariable Integer id){
        detallePedidoService.deleteDetallePedidoById(id);
    }
}

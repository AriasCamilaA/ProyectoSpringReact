package com.api.services;

import com.api.models.PedidoModel;
import com.api.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoModel createPedido(PedidoModel pedido){
        pedido.setEstado(true);
        return pedidoRepository.save(pedido);
    }
    public PedidoModel getPedidoById(Integer id){
        Optional<PedidoModel> optionalPedido = pedidoRepository.findById(id);
        return optionalPedido.get();
    }
    public List<PedidoModel> getAllPedidos(){
        return pedidoRepository.findAll();
    }
    public void deletePedidoById(Integer id){
        pedidoRepository.deleteById(id);
    }

}


package com.api.services;

import com.api.models.EstadoPedidoModel;
import com.api.repositories.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoPedidoService {

    @Autowired
    public EstadoPedidoRepository estadoPedidoRepository;

    public EstadoPedidoModel createEstadoPedido(EstadoPedidoModel estadoPedido) {
        estadoPedido.setEstado(true);
        return estadoPedidoRepository.save(estadoPedido);
    }

    public EstadoPedidoModel getEstadoPedidoById(Integer id) {
        Optional<EstadoPedidoModel> optionalEstadoPedido = estadoPedidoRepository.findById(id);
        return optionalEstadoPedido.get();
    }

    public List<EstadoPedidoModel> getAllEstadoPedidos() {
        return estadoPedidoRepository.findAll();
    }

    public void deleteEstadoPedidoById(Integer id){
        estadoPedidoRepository.deleteById(id);
    }
}

package com.api.services;

import com.api.models.DetallePedidoModel;
import com.api.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetallePedidoService {
    @Autowired
    public DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoModel createDetallePedido(DetallePedidoModel detallePedido){
        detallePedido.setEstado(true);
        return detallePedidoRepository.save(detallePedido);
    }

    public DetallePedidoModel getDetallePedidoById(Integer id){
        Optional<DetallePedidoModel> optionalDetallePedido = detallePedidoRepository.findById(id);
        return optionalDetallePedido.get();
    }

    public List<DetallePedidoModel> getAllDetallePedidos(){
        return detallePedidoRepository.findAll();
    }

    public void deleteDetallePedidoById(Integer id){
        detallePedidoRepository.deleteById(id);
    }
}

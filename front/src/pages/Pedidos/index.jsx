import React, { useEffect, useState } from 'react'
import apiService from '../../services';

const Pedidos = () => {

    const [pedidos, setPedidos] = useState([]);

    useEffect(()=>{
        apiService.getPedidos()
        .then((response) => {
            setPedidos(response);
          })
          .catch((error) => {
            console.error('Error al cargar los pedidos:', error);
        });
        
    }, []);

  return (
    <div class="table-responsive">
        <table class="table table-striped
        table-hover	
        table-borderless
        table-primary
        align-middle">
            <thead class="table-light">
                <caption>Table Name</caption>
                <tr>
                    <th>Descripción</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">
                    {
                        pedidos.map((pedido)=>{
                            <tr class="table-primary" >
                                <td>{pedido.descripcionPedido}</td>
                                <td>{pedido.fechaPedido}</td>
                                <td>{pedido.estadoPedido.nombreEstado}</td>
                            </tr>
                        })
                    }
                    <tr class="table-primary" >
                        <td>Item</td>
                        <td>Item</td>
                        <td>Item</td>
                    </tr>
                </tbody>
        </table>
    </div>
    
  )
}

export default Pedidos
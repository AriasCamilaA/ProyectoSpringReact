import axios from "axios";

const url = 'http://localhost:8080/api/';

const apiService = {
    // _________ Pedidos ___________________________________________________________
    getPedidos : async () => {
        try {
            const url_pedidos = url + "pedidos";
            const response = await axios.get(url_pedidos);
            const data = response.data;
            // console.log(data)
            return data;
        } catch (error) {
            console.error("API ERROR: PEDIDOS: "+error);
            throw error;
        }
        
    },
    getPedidosById : async (id) => {
        try {
            const url_pedidos = url + "pedidos/"+id;
            const response = await axios.get(url_pedidos);
            const data = response.data;
            // console.log(data)
            return data;
        } catch (error) {
            console.error("API ERROR: PEDIDO POR ID: "+error);
            throw error;
        }
        
    },
    createPedido : async (pedido) => {
        try {
            pedido.estado = 0;
            const url_pedidos = url + "pedidos";
            const response = await axios.post(url_pedidos, pedido);
            const data = response.data;
            return data;
        } catch (error) {
            console.error("API ERROR: REGISTRAR PEDIDO: "+error);
            throw error;
        }
        
    },
    // _________ Estados de Pedidos ___________________________________________________________
    getEstados : async () => {
        try {
            const url_estados = url + "estadopedidos";
            const response = await axios.get(url_estados);
            const data = response.data;
            // console.log(data)
            return data;
        } catch (error) {
            console.error("API ERROR: ESTADOS PEDIDO: "+error);
            throw error;
        }
        
    },
    // _________ Detalles de pedidos ___________________________________________________________
    getDetallesPedidos : async () => {
        try {
            const url_pedidos = url + "detallePedidos";
            const response = await axios.get(url_pedidos);
            const data = response.data;
            // console.log(data)
            return data;
        } catch (error) {
            console.error("API ERROR: DETALLE PEDIDOS: "+error);
            throw error;
        }
        
    },
    createDetallePedido : async (detallePedido) => {
        try {
            detallePedido.estado = 0;
            const url_detallesPedidos = url + "detallePedidos";
            const response = await axios.post(url_detallesPedidos, detallePedido);
            const data = response.data;
            return data;
        } catch (error) {
            console.error("API ERROR: REGISTRAR DETALLE PEDIDO: "+error);
            throw error;
        }
        
    },
    // _________ Productos ___________________________________________________________
    getProductos : async () => {
        try {
            const url_productos = url + "productos";
            const response = await axios.get(url_productos);
            const data = response.data;
            // console.log(data)
            return data;
        } catch (error) {
            console.error("API ERROR: ESTADOS PEDIDO: "+error);
            throw error;
        }
        
    },
}

export default apiService;
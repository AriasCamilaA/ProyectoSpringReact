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
    // _________ Pedidos ___________________________________________________________
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
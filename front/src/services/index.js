import axios from "axios";

const url = 'http://localhost:8080/api/';

const apiService = {
    
    getPedidos : async () => {
        try {
            const url_pedidos = url + "pedidos/";
            const response = await axios.get(url_pedidos);
            const data = response.data;
            return data;
        } catch (error) {
            console.error("API ERROR: PEDIDOS: "+error);
            throw error;
        }
        
    },
}

export default apiService;
import axios from "./api";

const mapa = "/mapa";

class MapaService {
    getAll() {
        return axios.get(mapa);
    }
}

export default new MapaService();
import axios from "./api";

const sistema = "/sistema";

class SistemaService {
    getAll() {
        return axios.get(sistema);
    }
}

export default new SistemaService();
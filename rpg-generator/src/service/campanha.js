import axios from "./api";

const campanha = "/campanha";

class CampanhaService {
    getAll() {
        return axios.get(campanha);
    }
}

export default new CampanhaService();
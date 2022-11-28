import axios from "./api";

const map = "/sistema";

class SistemaService {
    async getAll() {
        const res = await axios.get(map);
        return res.data;
    }

    async post(sistema) {
        console.log(sistema)
        const res = await axios.post(map, sistema);
        return res.data;
    }
}

export default new SistemaService();
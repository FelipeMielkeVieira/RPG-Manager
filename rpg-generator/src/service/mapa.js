import axios from "./api";

const map = "/mapa";

class MapaService {
    getAll() {
        return axios.get(map);
    }

    getByUser(user) {
        return axios.get(map + `/${user}`);
    }

    async post(mapa) {
        const formData = new FormData();
        formData.set("usuario", parseInt(mapa.id));
        formData.set("mapa", mapa.mapa);
        formData.set("nome", mapa.nomeMapa);
        const data = await axios.post(map, formData, { headers: { "Content-Type": "multipart/form-data" } });
        return data.data;
    }
}

export default new MapaService();
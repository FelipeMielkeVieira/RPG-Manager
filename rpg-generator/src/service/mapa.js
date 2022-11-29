import axios from "./api";

const map = "/mapa";

class MapaService {
    getAll() {
        return axios.get(map);
    }

    async post(mapa) {
        const formData = new FormData();
        formData.append("usuario", JSON.stringify({ id: mapa.id }));
        formData.append("mapa", mapa.mapa);
        formData.append("nome", mapa.nomeMapa);
        const data = await axios.post(map, formData, { headers: { "Content-Type": "multipart/form-data" } });
        return data.data;
    }
}

export default new MapaService();
import axios from "./api";

const map = "/campanha";

class CampanhaService {
    async getAll() {
        return (await axios.get(map)).data;
    }

    async getByAutor(email) {
        return (await axios.get(map + "/usuario/" + email)).data;
    }

    async post(dados) {
        const formData = new FormData();
        formData.append("campanha", JSON.stringify(dados.campanha));
        formData.append("logo", dados.logo);
        formData.append("mapa", dados.mapa);
        return (await axios.post(map, formData, { headers: { "Content-Type": "multipart/form-data" } })).data;
    }
}

export default new CampanhaService();
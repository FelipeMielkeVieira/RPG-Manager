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

    async put(campanha) {
        const formData = new FormData();

        formData.append("campanha", JSON.stringify({
            nome: campanha.nome,
            proxima_sessao: campanha.proxima_sessao,
            descricao: campanha.descricao,
            arquivada: campanha.arquivada,
            usuario: campanha.usuario,
            personagem: campanha.personagem,
            sessao: campanha.sessao,
            senha: campanha.senha
        }));
        formData.append("logo", campanha.imagem.id);
        formData.append("mapa", campanha.mapa.id);

        return (await axios.put(map + "/" + campanha.id, formData, { headers: { "Content-Type": "multipart/form-data" } })).data;
    }
}

export default new CampanhaService();
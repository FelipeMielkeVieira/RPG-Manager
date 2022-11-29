import axios from "./api";

const map = "/personagem";

class PersonagemService {
    async post(personagem, arquivos) {
        const formData = new FormData();
        formData.append("personagem", JSON.stringify(personagem));
        formData.append("arquivos", JSON.stringify(arquivos));
        
        const data = await axios.post(map, formData, { headers: { "Content-Type": "multipart/form-data" } });
        return data.data;
    }
}

export default new PersonagemService();
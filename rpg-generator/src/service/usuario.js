import axios from "./api";

const usuario = "/usuario";

class UsuarioService {
    getAll() {
        return axios.get(usuario);
    }

    post(usuarioData) {
        return axios.post(usuario, usuarioData);
    }

    login(email, senha) {
        return axios.get(usuario + `/login/${email}/${senha}`);
    }
}

export default new UsuarioService();
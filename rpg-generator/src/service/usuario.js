import axios from "./api";

const usuario = "/usuario";

class UsuarioService {
    getAll() {
        return axios.get(usuario);
    }

    getById(id) {
        return axios.get(usuario + `/${id}`)
    }

    post(usuarioData) {
        return axios.post(usuario, usuarioData);
    }

    login(email, senha) {
        return axios.get(usuario + `/login/${email}/${senha}`);
    }

    put(user) {
        return axios.put(usuario + `/${user.id}`, user);
    }
}

export default new UsuarioService();
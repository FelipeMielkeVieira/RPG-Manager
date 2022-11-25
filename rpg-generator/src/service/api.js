import axios from 'axios';

const api = axios.create({
    baseURL: "http://localhost:8080/rpg_manager"
    // headers: { 'Access-Control-Allow-Origin': "*" }
})

export default api;
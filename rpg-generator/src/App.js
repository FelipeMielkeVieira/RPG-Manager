import React from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";

import Login from "./pages/login/login";
import Cadastro from "./pages/cadastro/cadastro";
import HomeJogador from "./pages/homeJogador/homeJogador";
import HomeMestre from "./pages/homeMestre/homeMestre";
import EditPerfil from './pages/editPerfil/editPerfil';
import PaginaDados from './pages/paginaDados/paginaDados';
import Home from './pages/home/home';

import ToggleColorMode from './service/temaProvedor';

function App() {

  return (
    <ToggleColorMode>
      <Router>
        <Routes>
          <Route path='/' element={<Login></Login>}></Route>
          <Route path='/cadastro' element={<Cadastro></Cadastro>}></Route>
          <Route path='/home' element={<Home></Home>}></Route>
          <Route path='/home/jogador' element={<HomeJogador></HomeJogador>}></Route>
          <Route path='/home/mestre' element={<HomeMestre></HomeMestre>}></Route> 
          <Route path='/perfil' element={<EditPerfil></EditPerfil>}></Route> 
          <Route path='/home/jogador/dados' element={<PaginaDados></PaginaDados>}></Route>
        </Routes>
      </Router>
    </ToggleColorMode>
  );
}

export default App;

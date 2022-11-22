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

import ToggleColorMode from './service/temaProvedor';

function App() {
  return (
    <ToggleColorMode>
      <Router>
        <Routes>
          <Route path='/' element={<Login></Login>}></Route>
          <Route path='/cadastro' element={<Cadastro></Cadastro>}></Route>
          <Route path='/home/jogador' element={<HomeJogador></HomeJogador>}></Route>
          <Route path='/home/mestre' element={<HomeMestre></HomeMestre>}></Route>
        </Routes>
      </Router>
    </ToggleColorMode>
  );
}

export default App;

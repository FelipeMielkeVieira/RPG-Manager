import logo from './logo.svg';
import React from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";

import Login from "./components/pages/login/login";
import Cadastro from "./components/pages/cadastro/cadastro";

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Login></Login>}></Route>
        <Route path='/cadastro' element={<Cadastro></Cadastro>}></Route>
      </Routes>
    </Router>
  );
}

export default App;

import React from 'react'
import styles from "./login.module.css";

import imgDado from "../../../img/dado.png";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { Link } from "react-router-dom"

function login() {
    return (
        <div className={styles.mapaLogin}>
            <div className={styles.divPrincipal}>
                <div className={styles.divLogo}>
                    <img src={imgDado} className={styles.imgDado}></img>
                    <div className={styles.divNomeSistema}>
                        <h2 className={styles.nomeSistema}>RPG</h2>
                        <h2 className={styles.nomeSistema}>Manager</h2>
                    </div>
                </div>
                <TextField id="filled-basic-size-big" className={styles.inputsLogin} label="Nome ou Email" variant="filled" />
                <TextField id="filled-password-input" type="password" className={styles.inputsLogin} label="Senha" variant="filled" />
                <span className={styles.esqueciSenha}>Esqueci a Senha</span>
                <div className={styles.divBotoes}>
                    <Link to={"/cadastro"} className={styles.botoesEntrar}>
                        <Button variant="outlined">Cadastro</Button>
                    </Link>
                    <Button variant="contained">Entrar</Button>
                </div>
            </div>
        </div>
    )
}

export default login;
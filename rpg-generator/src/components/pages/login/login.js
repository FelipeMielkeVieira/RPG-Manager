import React from 'react'
import styles from "./login.module.css";

import imgDado from "../../../img/dado.png";
import TextField from '@mui/material/TextField';
import { Button, Alert, Collapse, IconButton } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import { Link } from "react-router-dom"

const Login = () => {

    const [alertaInvalido, setAlertaInvalido] = React.useState(false);
    const [dados, setDados] = React.useState({ email: "", senha: "" });

    const saveInput = (numInput, e) => {
        if (numInput == 1) {
            setDados({ ...dados, email: e.target.value });
        } else {
            setDados({ ...dados, senha: e.target.value });
        }
    }

    const login = () => {
        if (dados.email != "felipe@gmail" || dados.senha != "123") {
            setAlertaInvalido(true);
            setTimeout(() => {
                setAlertaInvalido(false);
            }, 3000);
        } else {

        }
    }

    return (
        <div className={styles.mapaLogin}>
            <Collapse in={alertaInvalido}>
                <Alert className={styles.alertaInvalido}
                    severity='error'
                    action={
                        <IconButton
                            aria-label="close"
                            color="inherit"
                            size="small"
                            onClick={() => {
                                setAlertaInvalido(false);
                            }}
                        >
                            <CloseIcon fontSize="inherit" />
                        </IconButton>
                    }
                    onClose={() => { }}>Email ou Senha Inválidos!</Alert>
            </Collapse>
            <div className={styles.divPrincipal}>
                <div className={styles.divLogo}>
                    <img src={imgDado} className={styles.imgDado}></img>
                    <div className={styles.divNomeSistema}>
                        <h2 className={styles.nomeSistema}>RPG</h2>
                        <h2 className={styles.nomeSistema}>Manager</h2>
                    </div>
                </div>
                <TextField onChange={(e) => { saveInput(1, e) }} value={dados.email} id="filled-basic-size-big" className={styles.inputsLogin} label="Email" variant="filled" />
                <TextField onChange={(e) => { saveInput(2, e) }} value={dados.senha} id="filled-password-input" type="password" className={styles.inputsLogin} label="Senha" variant="filled" />
                <span className={styles.esqueciSenha}>Esqueci a Senha</span>
                <div className={styles.divBotoes}>
                    <Link to={"/cadastro"} className={styles.botoesEntrar}>
                        <Button variant="outlined">Cadastro</Button>
                    </Link>
                    <Button variant="contained" onClick={() => { login() }}>Entrar</Button>
                </div>
            </div>
        </div>
    )
}

export default Login;
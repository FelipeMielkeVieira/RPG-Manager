import React, { useEffect } from 'react';
import { Link, useNavigate } from "react-router-dom";

import styles from "./login.module.css";

import TextField from '@mui/material/TextField';
import { Button, Alert, Collapse, IconButton } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';

import imgDado from "../../img/dado.png";

import UsuarioService from "../../service/usuario"

const Login = () => {

    const [alertaInvalido, setAlertaInvalido] = React.useState(false);
    const [alertaCadastro, setAlertaCadastro] = React.useState(false);
    const [dados, setDados] = React.useState({ email: "", senha: "" });
    const navigate = useNavigate();

    useEffect(() => {
        if (localStorage.getItem('cadastro')) {
            localStorage.removeItem('cadastro');
            setAlertaCadastro(true);
            setTimeout(() => {
                setAlertaCadastro(false);
            }, 3000);
        }
    }, []);

    const saveInput = (numInput, e) => {
        if (numInput == 1) {
            setDados({ ...dados, email: e.target.value });
        } else {
            setDados({ ...dados, senha: e.target.value });
        }
    }

    const login = async () => {
        try {
            console.log(dados)
            const data = await UsuarioService.login(dados.email, dados.senha);
            // localStorage.setItem("token", JSON.stringify(data.data));
            console.log(data.data);
            localStorage.setItem("email-user", JSON.stringify(data.data.email));
            navigate("/home");
        } catch (error) {
            setAlertaInvalido(true);
            setTimeout(() => {
                setAlertaInvalido(false);
            }, 3000);
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

            <Collapse in={alertaCadastro}>
                <Alert className={styles.alertaInvalido}
                    severity='success'
                    action={
                        <IconButton
                            aria-label="close"
                            color="inherit"
                            size="small"
                            onClick={() => {
                                setAlertaCadastro(false);
                            }}
                        >
                            <CloseIcon fontSize="inherit" />
                        </IconButton>
                    }
                    onClose={() => { }}>Cadastro efetuado com sucesso!</Alert>
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
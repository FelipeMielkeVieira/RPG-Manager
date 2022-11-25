import React, { useContext } from 'react'
import styles from "./cadastro.module.css";
import { useNavigate } from 'react-router-dom';

import imgDado from "../../img/dado.png";
import { TextField, Button, Alert, Collapse, IconButton } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import { Link } from "react-router-dom"

import api from "../../service/api";

const Cadastro = () => {

    const [alertaInvalido, setAlertaInvalido] = React.useState("");
    const [dados, setDados] = React.useState({ email: "", nome: "", senha: "", repetirSenha: "" });
    const navigate = useNavigate();

    const cadastrar = async () => {
        if (dados.email && dados.nome && dados.senha) {
            if(dados.senha == dados.repetirSenha) {
                let dadosNovos = { email: dados.email, nome: dados.nome, senha: dados.senha }
                const data = await api.post("/rpg_manager/usuario", dadosNovos);
                localStorage.setItem("cadastro", "1")
                navigate('/');
            } else {
                abrirFeedback(2);
            }
        } else {
            abrirFeedback(1);
        }
    }

    const abrirFeedback = (numero) => {
        if(numero == 1) {
            setAlertaInvalido("Preencha todos os campos!");
        } else {
            setAlertaInvalido("As senhas não coincidem!");
        }
        setTimeout(() => {
            setAlertaInvalido("");
        }, 3000);
    }

    const saveInput = (numero, e) => {
        switch (numero) {
            case 1:
                setDados({ ...dados, nome: e.target.value });
                break;
            case 2:
                setDados({ ...dados, email: e.target.value });
                break;
            case 3:
                setDados({ ...dados, senha: e.target.value });
                break;
            default:
                setDados({ ...dados, repetirSenha: e.target.value });
                break;
        }
    }

    return (
        <div className={styles.mapaLogin}>

            <Collapse in={alertaInvalido != ""}>
                <Alert className={styles.alertaInvalido}
                    severity='error'
                    action={
                        <IconButton
                            aria-label="close"
                            color="inherit"
                            size="small"
                            onClick={() => {
                                setAlertaInvalido("");
                            }}
                        >
                            <CloseIcon fontSize="inherit" />
                        </IconButton>
                    }
                    onClose={() => { }}>{alertaInvalido}</Alert>
            </Collapse>

            <div className={styles.divPrincipal}>
                <div className={styles.divLogo}>
                    <img src={imgDado} className={styles.imgDado}></img>
                    <div className={styles.divNomeSistema}>
                        <h2 className={styles.nomeSistema}>RPG</h2>
                        <h2 className={styles.nomeSistema}>Manager</h2>
                    </div>
                </div>
                <TextField value={dados.nome} onChange={(e) => { saveInput(1, e) }} id="filled-basic-size-big" className={styles.inputsLogin} label="Nome" variant="filled" />
                <TextField value={dados.email} onChange={(e) => { saveInput(2, e) }} id="filled-basic-size-big" className={styles.inputsLogin} label="Email" variant="filled" />
                <TextField value={dados.senha} onChange={(e) => { saveInput(3, e) }} id="filled-password-input" type="password" className={styles.inputsLogin} label="Senha" variant="filled" />
                <TextField value={dados.repetirSenha} onChange={(e) => { saveInput(4, e) }} id="filled-password-input" type="password" className={styles.inputsLogin} label="Repetir Senha" variant="filled" />
                <span className={styles.esqueciSenha}>Esqueci a Senha</span>
                <div className={styles.divBotoes}>
                    <Link to={"/"} className={styles.botoesEntrar}>
                        <Button variant="outlined">Login</Button>
                    </Link>
                    <Button variant="contained" onClick={() => { cadastrar() }}>Cadastrar</Button>
                </div>
            </div>
        </div>
    )
}

export default Cadastro;
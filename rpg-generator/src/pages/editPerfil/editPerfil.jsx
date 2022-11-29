import React, { useState, useEffect } from 'react'

import { Box, Typography, Divider, TextField, Button, Collapse, Alert, IconButton } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import Sidebar from '../../components/sidebar/sidebar'

import styles from './editPerfil.module.css';
import UsuarioService from "../../service/usuario"

const EditPerfil = () => {

  const [aba, setAba] = useState("jogador");
  const [dados, setDados] = useState({ nome: "", email: "", senha: "", repetirSenha: "" });
  const [usuario, setUsuario] = useState({ email: "", nome: "", senha: "" });

  const [alertaSenhaIncorreta, setAlertaSenhaIncorreta] = useState(false);
  const [alertaAlteracoesSalvas, setAlertaAlteracoesSalvas] = useState(false);

  useEffect(() => {
    buscarUsuario();
  }, []);

  const buscarUsuario = async () => {
    let usuarioSalvo = parseInt(localStorage.getItem('userId'));
    const dado = (await UsuarioService.getById(usuarioSalvo)).data;

    setDados({ ...dados, email: dado.email, nome: dado.nome });
    setUsuario(dado);
  }

  const saveInput = (numero, e) => {
    switch (numero) {
      case 1:
        setDados({ ...dados, nome: e.target.value })
        break;
      case 2:
        setDados({ ...dados, email: e.target.value })
        break;
      case 3:
        setDados({ ...dados, senha: e.target.value })
        break;
      case 4:
        setDados({ ...dados, repetirSenha: e.target.value })
        break;
    }
  }

  const salvarAlteracoes = () => {
    if (dados.senha == dados.repetirSenha) {
      if (dados.senha || dados.email || dados.nome) {
        atualizarUser();
        setAlertaAlteracoesSalvas(true);
        setTimeout(() => {
          setAlertaAlteracoesSalvas(false);
        }, 3000);
      }
    } else {
      setAlertaSenhaIncorreta(true);
      setTimeout(() => {
        setAlertaSenhaIncorreta(false);
      }, 3000);
    }
  }

  const atualizarUser = async () => {
    let usuarioNovo = { ...usuario };
    if (dados.email != '') {
      usuarioNovo.email = dados.email;
    }
    if (dados.nome != '') {
      usuarioNovo.nome = dados.nome;
    }
    if (dados.senha != '') {
      usuarioNovo.senha = dados.senha;
    }

    await UsuarioService.put(usuarioNovo);
  }

  return (
    <Sidebar aba={aba} setAba={setAba}>
      <Box p='1.5rem 3rem'>
        <Collapse in={alertaSenhaIncorreta}>
          <Alert className={styles.alertaInvalido}
            severity='error'
            action={
              <IconButton
                aria-label="close"
                color="inherit"
                size="small"
                onClick={() => {
                  setAlertaSenhaIncorreta(false);
                }}
              >
                <CloseIcon fontSize="inherit" />
              </IconButton>
            }
            onClose={() => { }}>As senhas não coincidem!</Alert>
        </Collapse>

        <Collapse in={alertaAlteracoesSalvas}>
          <Alert className={styles.alertaInvalido}
            severity='success'
            action={
              <IconButton
                aria-label="close"
                color="inherit"
                size="small"
                onClick={() => {
                  setAlertaAlteracoesSalvas(false);
                }}
              >
                <CloseIcon fontSize="inherit" />
              </IconButton>
            }
            onClose={() => { }}>Alterações salvas com sucesso!</Alert>
        </Collapse>

        <Box className='flex gap-12'>
          <Typography className='cursor-pointer' variant='h5' color='text.secondary'>Perfil</Typography>
        </Box>
        <Divider sx={{ borderWidth: '1px' }} />
        <Box p='1.5rem 0rem'>
          <TextField fullWidth onChange={(e) => { saveInput(1, e) }} value={dados.nome} id="filled-basic-size-big" label="Nome de Usuário" variant="filled" />
          <TextField sx={{ marginTop: '2rem' }} fullWidth onChange={(e) => { saveInput(2, e) }} value={dados.email} id="filled-basic-size-big" label="Email" variant="filled" />
        </Box>
        <Box className='flex gap-12'>
          <Typography className='cursor-pointer' variant='h5' color='text.secondary'>Senha</Typography>
        </Box>
        <Divider sx={{ borderWidth: '1px' }} />
        <Box p='1.5rem 0rem'>
          <TextField fullWidth onChange={(e) => { saveInput(3, e) }} value={dados.senha} id="filled-password-input" type='password' label="Nova Senha" variant="filled" />
          <TextField sx={{ marginTop: '2rem' }} fullWidth onChange={(e) => { saveInput(4, e) }} value={dados.repetirSenha} id="filled-password-input" type='password' label="Repetir Senha" variant="filled" />
        </Box>
        <Button variant='contained' size='large' onClick={salvarAlteracoes}>
          Salvar Alterações
        </Button>
      </Box>
    </Sidebar>
  )
}

export default EditPerfil
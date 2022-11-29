import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'

import { Box, Button, Typography, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, TextField, Paper } from '@mui/material'

import CampanhaService from '../../service/campanha'

const CampanhasMestre = () => {
  const [open, setOpen] = useState(false);
  const [campanhaSelecionada, setCampanhaSelecionada] = useState(null);
  const [campanhas, setCampanhas] = useState([]);
  const [novaSessao, setNovaSessao] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    console.log()
    getCampanhas();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const getCampanhas = () => {
    CampanhaService.getByAutor(JSON.parse(localStorage.getItem("email-user"))).then((response) => {
      console.log(response);
      setCampanhas(response)
    })
  }

  const handleClickOpen = (campanha) => {
    setOpen(true);
    setCampanhaSelecionada(campanha)
  }

  const arquivarCampanha = (campanha) => {
    campanha.arquivada = true;
    CampanhaService.put(campanha).then((response) => {
      console.log(response);
      setCampanhas(response);
      getCampanhas();
    })
  }

  const addNovaSessao = (campanha) => {
    campanha.proxima_sessao = novaSessao;
    CampanhaService.put(campanha).then((response) => {
      console.log(response);
      setCampanhas(response);
      getCampanhas();
    })
  }

  const getNovaDataSessao = (data) => {
    return new Date(data).toLocaleDateString('pt-BR', { timeZone: 'UTC' });
  }

  return (
    <Box className='mt-6'>
      <Box className='flex justify-between mb-6'>
        <Box className='px-2 py-1 w-1/3 border outline-none' component='input' placeholder="Buscar campanha" />
        <Button onClick={() => { navigate("/criar-campanha") }} sx={{ fontWeight: '600' }} color='tertiary' variant="contained" disableElevation>Criar campanha</Button>
      </Box>

      <Box>
        {campanhas.length > 0
          ?
          (campanhas?.map((campanha, index) => {
            return (
              <Paper key={index} onClick={() => handleClickOpen(campanha)} className='grid grid-cols-4 gap-6 items-center p-4 cursor-pointer transition duration-300 hover:opacity-95 hover:transition hover:duration-300 mb-4' sx={{ borderLeft: '10px solid', borderColor: 'secondary.main' }}>
                <Box className='flex items-center w-12 h-12'>
                  <img classNmae="w-full h-full" src={"data:" + campanha.mapa.arquivo.tipo + ";base64," + campanha.mapa.arquivo.dados} alt="Campanha imagem" />
                </Box>
                <Typography fontSize='22px' color='text.white'>{campanha.nome}</Typography>
                <Typography fontSize='22px' color='text.white'>Jogadores: {campanha.personagem.length}</Typography>
                <Typography fontSize='22px' color='text.white'>Prox. Sessão: {campanha.proxima_sessao ? getNovaDataSessao(campanha.proxima_sessao.slice(0, 10).replaceAll("-", "/")) : " A  definir"}</Typography>
              </Paper>
            )

          }))
          :
          null}
      </Box>

      <Dialog open={open} onClose={() => { setOpen(false); }}>
        <DialogTitle sx={{ backgroundColor: "background.default" }} color='text.secondary'>{campanhaSelecionada?.nome} #{campanhaSelecionada?.id}</DialogTitle>
        <DialogContent sx={{ backgroundColor: "background.default" }}>
          <DialogContentText color="text.primary">
            Selecione o que irá acontecer com a campanha
          </DialogContentText>
          <Box className='w-full mt-4'>
            <input id='data-nova-sessao' value={novaSessao} onChange={(e) => setNovaSessao(e.target.value)} type="date" className='w-full p-2 border rounded' />
          </Box>
        </DialogContent>
        <DialogActions sx={{ backgroundColor: "background.default" }}>
          <Button onClick={() => { setOpen(false); }}>Cancelar</Button>
          <Button variant='contained' color='tertiary' disableElevation onClick={() => { arquivarCampanha(campanhaSelecionada); setOpen(false); }}>Arquivar</Button>
          <Button variant='contained' color='secondary' disableElevation onClick={() => { addNovaSessao(campanhaSelecionada); setOpen(false); }}>Adicionar nova sessão</Button>
        </DialogActions>
      </Dialog>
    </Box >
  )
}

export default CampanhasMestre
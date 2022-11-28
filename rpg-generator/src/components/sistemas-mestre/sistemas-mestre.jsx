import React, { useState, useEffect } from 'react'

import { Box, Button, Typography, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, TextField, } from '@mui/material'

import ItemListModel from '../item-list-model/item-list-model'

import SistemaService from '../../service/sistema'

const SistemasMestre = () => {
  const [sistemas, setSistemas] = useState([])
  const [open, setOpen] = useState(false);
  const [descricaoSistema, setDescricaoSistema] = useState("");
  const [nomeSistema, setNomeSistema] = useState("");

  useEffect(() => {
    getSistemas();
  }, [])

  const getSistemas = () => {
    SistemaService.getAll().then((response) => {
      setSistemas(response);
    });
  }

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const saveSystem = () => {
    console.log("descricaoSistema: ", descricaoSistema);
    SistemaService.post({ descricao: descricaoSistema, nome: nomeSistema, date: new Date().toISOString().slice(0, 19), usuario: { email: JSON.parse(localStorage.getItem('email-user')) } }).then((response) => {
      console.log("response: ", response);
      getSistemas();
    }).catch((error) => {
      console.log("error: ", error);
    });
  }

  return (
    <Box className='mt-6'>
      <Box className='flex justify-between mb-6'>
        <Box className='px-2 py-1 w-1/3 border outline-none' component='input' placeholder="Buscar sistema" />
        <Button onClick={() => { handleClickOpen() }} sx={{ fontWeight: '600' }} color='tertiary' variant="contained" disableElevation>Novo sistema</Button>
      </Box>

      {sistemas?.map((sistema, index) => {
        return (
          <ItemListModel key={index} >
            <Typography fontSize='22px' color='text.white'>{sistema.nome}</Typography>
            <Typography fontSize='22px' color='text.white'>{sistema.date}</Typography>
          </ItemListModel>
        )
      })}
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle sx={{ backgroundColor: "background.default" }} color='text.secondary'>Sistema</DialogTitle>
        <DialogContent sx={{ backgroundColor: "background.default" }}>
          <DialogContentText color="text.primary">
            Para adicionar um novo sistema, preencha o campo abaixo.
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="nome"
            label="Nome"
            type="text"
            fullWidth
            variant="standard"
            value={nomeSistema}
            onChange={(e) => { setNomeSistema(e.target.value) }}
          />
          <TextField
            autoFocus
            margin="dense"
            id="nome"
            label="Descrição"
            type="text"
            fullWidth
            multiline
            rows={4}
            variant="standard"
            value={descricaoSistema}
            onChange={(e) => { setDescricaoSistema(e.target.value) }}
          />
        </DialogContent>
        <DialogActions sx={{ backgroundColor: "background.default" }}>
          <Button onClick={handleClose}>Cancelar</Button>
          <Button variant='contained' color='secondary' disableElevation onClick={() => { saveSystem(); handleClose(); }}>Adicionar</Button>
        </DialogActions>
      </Dialog>
    </Box>
  )
}

export default SistemasMestre
import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'

import { Box, Button, Typography } from '@mui/material'

import ItemListModel from '../item-list-model/item-list-model'

import CampanhaService from '../../service/campanha'

const CampanhasMestre = () => {
  const [campanhas, setCampanhas] = useState([]);
  const listCampanhas = [{ nome: 'O Segredo na Ilha', jogadores: 5, data: '24/11/2022' }]
  const navigate = useNavigate();

  useEffect(() => {
    CampanhaService.getAll().then((response) => {
      console.log(response);
      setCampanhas(response.data)
    })

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <Box className='mt-6'>
      <Box className='flex justify-between mb-6'>
        <Box className='px-2 py-1 w-1/3 border outline-none' component='input' placeholder="Buscar campanha" />
        <Button onClick={() => { navigate("/criar-campanha") }} sx={{ fontWeight: '600' }} color='tertiary' variant="contained" disableElevation>Criar campanha</Button>
      </Box>

      {listCampanhas.map((campanha, index) => {
        return <ItemListModel key={index} campanha={campanha} >
          <Typography fontSize='22px' color='text.white'>{campanha.nome}</Typography>
          <Typography fontSize='22px' color='text.white'>{campanha.nome}</Typography>
          <Typography fontSize='22px' color='text.white'>Jogadores: {campanha.jogadores}</Typography>
          <Typography fontSize='22px' color='text.white'>{campanha.data}</Typography>
        </ItemListModel>
      })}
    </Box>
  )
}

export default CampanhasMestre
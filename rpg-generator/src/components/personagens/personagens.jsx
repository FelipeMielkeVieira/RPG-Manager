import React from 'react'
import { useNavigate } from 'react-router-dom'

import { Box, Button } from '@mui/material'

const Personagens = () => {
  const navigate = useNavigate();

  return (
    <Box className='mt-6'>
      <Box className='w-full flex justify-end' >
        <Button onClick={() => navigate("/criar-personagem")} variant='contained' color='tertiary' disableElevation>Novo Personagem</Button>
      </Box>
    </Box>
  )
}

export default Personagens
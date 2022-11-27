import React, { useState } from 'react'

import { Box, Typography, Divider } from '@mui/material';

import CampanhasMestre from '../components/campanhas-mestre/campanhas-mestre';
import SistemasMestre from '../components/sistemas-mestre/sistemas-mestre';

const ConteudoMestre = () => {
    const [abaConteudo, setAbaConteudo] = useState("campanhas");

    return (
        <Box p='2rem 3rem'>
            {abaConteudo == "campanhas"
                ?
                <Box className='flex gap-12'>
                    <Typography className='cursor-pointer' variant='h5' color='text.secondary'>Campanhas</Typography>
                    <Typography className='cursor-pointer' variant='h5' onClick={() => setAbaConteudo("personagens")} color='text.black'>Sistemas</Typography>
                </Box>
                :
                <Box className='flex gap-12'>
                    <Typography className='cursor-pointer' variant='h5' onClick={() => setAbaConteudo("campanhas")} color='text.black'>Campanhas</Typography>
                    <Typography className='cursor-pointer' variant='h5' color='text.secondary'>Sistemas</Typography>
                </Box>
            }
            <Divider sx={{ borderWidth: '1px' }} />

            {abaConteudo == "campanhas"
                ? <CampanhasMestre />
                : <SistemasMestre />
            }
        </Box>
    )
}

export default ConteudoMestre
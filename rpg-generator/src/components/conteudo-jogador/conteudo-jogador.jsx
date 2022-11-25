import React, { useState } from 'react'

import { Box, Typography, Divider } from '@mui/material';
import Campanhas from '../campanhas/campanhas';
import Personagens from '../personagens/personagens';

function ConteudoJogador() {
    const [abaConteudo, setAbaConteudo] = useState("campanhas");

    return (
        <Box p='2rem 3rem'>
            {abaConteudo == "campanhas"
                ?
                <Box className='flex gap-12'>
                    <Typography className='cursor-pointer' variant='h5' color='text.secondary'>Campanhas</Typography>
                    <Typography className='cursor-pointer' variant='h5' onClick={() => setAbaConteudo("personagens")} color='text.black'>Personagens</Typography>
                </Box>
                :
                <Box className='flex gap-12'>
                    <Typography className='cursor-pointer' variant='h5' onClick={() => setAbaConteudo("campanhas")} color='text.black'>Campanhas</Typography>
                    <Typography className='cursor-pointer' variant='h5' color='text.secondary'>Personagens</Typography>
                </Box>
            }
            <Divider sx={{ borderWidth: '1px' }} />

            {abaConteudo == "campanhas"
                ? <Campanhas />
                : <Personagens />
            }
        </Box>

    )
}

export default ConteudoJogador
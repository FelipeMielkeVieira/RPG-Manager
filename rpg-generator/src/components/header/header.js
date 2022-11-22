import React from 'react'
import { useNavigate, useLocation } from "react-router-dom"

import { Box, Typography } from '@mui/material'

import Logo from "../../img/d20Claro.png";
import Bell from "../../img/sino.png";
import User from "../../img/user.png";

const Header = () => {
    const navigate = useNavigate();
    const location = useLocation();

    const abaJogador = () => {
        navigate("/home/jogador");
    }

    const abaMestre = () => {
        navigate("/home/mestre");
    }

    return (
        <Box className='flex justify-between h-20 p-4' sx={{ backgroundColor: 'primary.main' }}>
            <Box className='flex h-full items-center'>
                <img src={Logo} className="h-full mr-12 hover:cursor-pointer" onClick={() => { navigate("/home/jogador") }} />
                {location.pathname == "/home/jogador"
                    ?
                    <Box className='flex gap-12'>
                        <Typography className='cursor-pointer' variant='h5' onClick={abaJogador} color='text.secondary'>Jogador</Typography>
                        <Typography className='cursor-pointer' variant='h5' onClick={abaMestre} color='text.white'>Mestre</Typography>
                    </Box>
                    :
                    <Box>
                        <Typography className='cursor-pointer' variant='h5' onClick={abaJogador} color='text.white'>Jogador</Typography>
                        <Typography className='cursor-pointer' variant='h5' onClick={abaMestre} color='text.secondary'>Mestre</Typography>
                    </Box>
                }
            </Box>
            <Box className='flex items-center gap-4'>
                <img src={Bell} className="h-3/4 cursor-pointer" />
                <img src={User} className="h-3/4 cursor-pointer" />
            </Box>
        </Box>
    )
}

export default Header
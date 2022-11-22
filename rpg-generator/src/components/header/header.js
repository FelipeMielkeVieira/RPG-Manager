import React, { useState } from 'react'
import { useNavigate, useLocation } from "react-router-dom"

import { Box, Typography, Menu, MenuItem } from '@mui/material'
import BorderColorOutlinedIcon from '@mui/icons-material/BorderColorOutlined';
import LogoutOutlinedIcon from '@mui/icons-material/LogoutOutlined';

import Logo from "../../img/d20Claro.png";
import Bell from "../../img/sino.png";
import User from "../../img/user.png";

const Header = () => {
    const [user, setUser] = useState({ nome: "Nome", sobrenome: "Sobrenome" })
    const [userModalVisibility, setUserModalVisibility] = useState(true);
    const navigate = useNavigate();
    const location = useLocation();

    const abaJogador = () => {
        navigate("/home/jogador");
    }

    const abaMestre = () => {
        navigate("/home/mestre");
    }

    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    const logout = () => {
        navigate("/");
    }

    return (
        <Box className='flex justify-between h-20 p-4 w-full' sx={{ backgroundColor: 'primary.main' }}>
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
                <img src={User} onClick={handleClick} className="h-3/4 cursor-pointer" />
                {userModalVisibility &&
                    <>
                        <Menu
                            id="basic-menu"
                            anchorEl={anchorEl}
                            open={open}
                            onClose={handleClose}
                            MenuListProps={{
                                'aria-labelledby': 'basic-button',
                            }}
                        >
                            <Box className='p-2'>
                                <Typography fontSize='18px' fontWeight='600' >{user.nome} {user.sobrenome}</Typography>
                                <MenuItem sx={{ padding: 0, paddingY: '6px', paddingX: '4px', display: 'flex', gap: '8px' }} onClick={() => { handleClose(); navigate("/perfil") }}> <BorderColorOutlinedIcon /> Editar Perfil</MenuItem>
                                <Typography onClick={logout} className='flex align-middle gap-1 justify-end'>
                                    <Box className='cursor-pointer'>
                                        <LogoutOutlinedIcon />
                                        Sair
                                    </Box>
                                </Typography>
                            </Box>
                        </Menu>
                    </>
                }
            </Box>
        </Box>
    )
}

export default Header
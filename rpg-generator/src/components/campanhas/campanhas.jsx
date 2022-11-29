import React, { useState, useEffect } from 'react'

import { Box, Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, TextField } from '@mui/material'

import Campanha from '../campanha/campanha'
import CampanhaService from '../../service/campanha'

const Campanhas = () => {
    const [campanhas, setCampanhas] = useState([]);
    const [nome, setNome] = useState("");
    const [senha, setSenha] = useState("");
    const listCampanhas = [{ nome: 'O Segredo na Ilha', criador: 'Edson Grucker', data: '24/11/2022' }]
    const [openDialogCampanha, setOpenDialogCampanha] = useState(false)

    useEffect(() => {
        // CampanhaService.getAll().then((response) => {
        //     console.log(response);
        //     setCampanhas(response.data)
        // })

        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    const handleClickOpen = () => {
        setOpenDialogCampanha(true);
    };

    const handleClose = () => {
        setOpenDialogCampanha(false);
    };

    const entrarEmCampanha = () => {
        
    }

    return (
        <Box className='mt-6'>
            <Box className='flex justify-between mb-6'>
                <Box className='px-2 py-1 w-1/3 border outline-none' component='input' placeholder="Buscar campanha" />
                <Button onClick={handleClickOpen} sx={{ fontWeight: '600' }} color='tertiary' variant="contained" disableElevation>Entrar em campanha</Button>
            </Box>

            {listCampanhas.map((campanha, index) => {
                return <Campanha key={index} campanha={campanha} />
            })}

            <Dialog open={openDialogCampanha} onClose={handleClose}>
                <Box bgcolor="white">
                    <DialogTitle color='secondary'>Entrar em Campanha</DialogTitle>
                    <DialogContent>
                        <Box>
                            <label>
                                Nome da Campanha
                                <Box value={nome} onChange={(e) => setNome(e.target.value)} component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} />
                            </label>
                            <label>
                                Senha
                                <Box value={senha} onChange={(e) => setSenha(e.target.value)} component="input" type="password" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} />
                            </label>
                        </Box>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={handleClose}>Cancelar</Button>
                        <Button onClick={() => { entrarEmCampanha(); handleClose(); }}>Entrar</Button>
                    </DialogActions>
                </Box>
            </Dialog>
        </Box>
    )
}

export default Campanhas
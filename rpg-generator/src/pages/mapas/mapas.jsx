import React, { useState, useEffect } from 'react'

import { Box, Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Modal, Paper, Stack, TextField, Typography } from '@mui/material';

import UploadArquivoCinza from "../../img/uploadArquivoCinza.png"
import Sidebar from '../../components/sidebar/sidebar'

import MapaService from "../../service/mapa";

const Mapas = () => {
    const [nomeMapa, setNomeMapa] = useState("");
    const [aba, setAba] = useState("mestre");
    const [open, setOpen] = useState(false);
    const [img, setImg] = useState(UploadArquivoCinza);

    const [mapas, setMapas] = useState([]);

    useEffect(() => {
        getMapas();
    }, []);

    const getMapas = () => {
        MapaService.getAll().then((response) => {
            console.log("mapa: ", response.data);
            setMapas(response.data);
        })
    }

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setImg(UploadArquivoCinza);
        setNomeMapa("");
        setOpen(false);
    };

    const onFileUploadClick = () => {
        document.getElementById('mapaInput').click();
    }

    const saveMapa = () => {
        const mapa = document.getElementById('mapaInput').files[0];
        console.log(mapa);
        const id = JSON.parse(localStorage.getItem("userId"));
        console.log("img: ", mapa);
        MapaService.post({ mapa, id, nomeMapa }).then((response) => {
            console.log("response: ", response);
            getMapas();
        })
    }

    return (
        <Sidebar aba={aba} setAba={setAba}>
            <Box p='2rem 3rem'>
                <Box className='flex justify-between mb-6'>
                    <Box className='px-2 py-1 w-1/3 border outline-none' component='input' placeholder="Buscar mapa" />
                    <Button onClick={handleClickOpen} sx={{ fontWeight: '600' }} color='tertiary' variant="contained" disableElevation>Adicionar</Button>
                </Box>

                <Box className='grid grid-cols-4 gap-x-10 gap-y-4'>
                    {mapas?.map((mapa, index) => {
                        let imagem = "data:" + mapa.arquivo.tipo + ";base64," + mapa.arquivo.dados;

                        return (
                            <Paper key={index} className='flex items-center gap-16 w-full p-4 cursor-pointer transition duration-300 hover:opacity-95 hover:transition hover:duration-300 mb-4' sx={{ borderLeft: '10px solid', borderColor: 'secondary.main' }}>
                                <Box className='w-20 h-20 flex items-center'>
                                    <img className="w-full" src={imagem} alt="Imagem" />
                                </Box>
                                <Box className="w-full flex justify-center">
                                    <Typography fontSize='22px' color='text.white'>{mapa.nome}</Typography>
                                </Box>
                            </Paper>
                        )
                    })}
                </Box>

                <Dialog open={open} onClose={handleClose}>
                    <DialogTitle sx={{ backgroundColor: "background.default" }} color='text.secondary'>Mapa</DialogTitle>
                    <DialogContent sx={{ backgroundColor: "background.default" }}>
                        <Box className='flex justify-center w-96 h-60 border rounded cursor-pointer' onClick={onFileUploadClick}>
                            <img className='w-60 h-60' src={img} alt="" />
                            <input onChange={() => {
                                setImg(URL.createObjectURL(document.getElementById('mapaInput').files[0]))
                            }} type="file" id="mapaInput" hidden />
                        </Box>
                        <TextField value={nomeMapa} onChange={(e) => setNomeMapa(e.target.value)} sx={{ backgroundColor: "background.default", marginTop: "1rem" }} className='mt-8' fullWidth label="Nome do mapa" variant="standard" />
                    </DialogContent>
                    <DialogActions sx={{ backgroundColor: "background.default" }}>
                        <Button onClick={handleClose}>Cancelar</Button>
                        <Button variant='contained' color='secondary' disableElevation onClick={() => { saveMapa(); handleClose(); }}>Adicionar</Button>
                    </DialogActions>
                </Dialog>

            </Box>
        </Sidebar>
    )
}

export default Mapas
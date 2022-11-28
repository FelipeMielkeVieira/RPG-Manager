import React, { useState, useEffect } from 'react'

import { Box, Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Modal, Stack, TextField, Typography } from '@mui/material';

import UploadArquivoCinza from "../../img/uploadArquivoCinza.png"
import Sidebar from '../../components/sidebar/sidebar'
import ItemListModel from '../../components/item-list-model/item-list-model';

import MapaService from "../../service/mapa";

const Mapas = () => {
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
        setOpen(false);
    };

    const onFileUploadClick = () => {
        document.getElementById('mapaInput').click();
    }

    const saveMapa = () => {
        const mapa = document.getElementById('mapaInput').files[0];
        console.log(mapa);
        const emailUser = JSON.parse(localStorage.getItem("email-user"));
        console.log("img: ", mapa);
        MapaService.post({ mapa, emailUser }).then((response) => {
            console.log("response: ", response);
        })
    }

    return (
        <Sidebar aba={aba} setAba={setAba}>
            <Box p='2rem 3rem'>
                <Box className='flex justify-between mb-6'>
                    <Box className='px-2 py-1 w-1/3 border outline-none' component='input' placeholder="Buscar campanha" />
                    <Button onClick={handleClickOpen} sx={{ fontWeight: '600' }} color='tertiary' variant="contained" disableElevation>Adicionar</Button>
                </Box>

                {mapas?.map((mapa, index) => {
                    let imagem = "data:" + mapa.arquivo.tipo + ";base64," + mapa.arquivo.dados;

                    return (
                        <ItemListModel key={index} >
                            <Box className='w-20 h-20'>
                                <img src={imagem} alt="Imagem" />
                            </Box>
                            <Typography fontSize='22px' color='text.white'>{mapa.arquivo.nome}</Typography>
                        </ItemListModel>
                    )
                })}

                <Dialog open={open} onClose={handleClose}>
                    <DialogTitle sx={{ backgroundColor: "background.default" }} color='text.secondary'>Mapa</DialogTitle>
                    <DialogContent sx={{ backgroundColor: "background.default" }}>
                        <Box className='flex justify-center w-96 h-60 border rounded cursor-pointer' onClick={onFileUploadClick}>
                            <img className='w-60 h-60' src={img} alt="" />
                            <input onChange={() => {
                                setImg(URL.createObjectURL(document.getElementById('mapaInput').files[0]))
                            }} type="file" id="mapaInput" hidden />
                        </Box>
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
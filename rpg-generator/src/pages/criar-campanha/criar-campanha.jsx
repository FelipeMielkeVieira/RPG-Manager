import React, { useState, useEffect } from 'react'

import { Box, Button, Divider, Typography } from '@mui/material';

import MapaService from '../../service/mapa.js';
import SistemaService from '../../service/sistema.js';

import Sidebar from '../../components/sidebar/sidebar'
import UploadArquivoCinza from "../../img/uploadArquivoCinza.png"

const CriarCampanha = () => {
    const [aba, setAba] = useState("mestre");
    const [mapas, setMapas] = useState([]);
    const [sistemas, setSistemas] = useState([]);

    useEffect(() => {
        MapaService.getAll().then((response) => {
            console.log("mapa: ", response.data);
            setMapas(response.data);
        })

        SistemaService.getAll().then((response) => {
            console.log("sistema: ", response.data);
            setSistemas(response.data);
        })
    }, []);

    return (
        <Sidebar aba={aba} setAba={setAba}>
            <Box p='2rem 3rem'>
                <Box className='flex gap-12'>
                    <Typography variant='h5' color='text.secondary'>Criar campanhas</Typography>
                </Box>
                <Divider sx={{ borderWidth: '1px' }} />

                {/* Container conteudo */}
                <Box className='w-full pt-4'>
                    <Box className='flex gap-20'>
                        {/* left part */}
                        <Box className='w-3/4'>
                            <label>
                                Campanha
                                <Box component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} placeholder='Nome da campanha' />
                            </label>
                            <label>
                                Mapa
                                <Box component="select" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} >
                                    {mapas.map((mapa, index) => {
                                        return <option key={index} value={mapa.id}>{mapa.nome}</option>
                                    })}
                                </Box>
                            </label>
                            <label>
                                Sistema utlizado
                                <Box component="select" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} >
                                    {sistemas.map((sistema, index) => {
                                        return <option key={index} value={sistema.id}>{sistema.nome}</option>
                                    })}
                                </Box>
                            </label>
                        </Box>

                        {/* right part */}
                        <Box className='w-1/4'>
                            <label>
                                Logo da campanha
                                <input type="file" hidden />
                                <Box className='flex justify-center items-center w-full h-72 border rounded'>
                                    <img src={UploadArquivoCinza} className='w-10/12 h-11/12 ' />
                                </Box>
                            </label>
                        </Box>
                    </Box>
                    <Box className='flex justify-end mt-12'>
                        <Button variant='contained' color='secondary' sx={{ color: "white" }} disableElevation>Criar campanha</Button>
                    </Box>
                </Box>
            </Box>
        </Sidebar>
    )
}

export default CriarCampanha
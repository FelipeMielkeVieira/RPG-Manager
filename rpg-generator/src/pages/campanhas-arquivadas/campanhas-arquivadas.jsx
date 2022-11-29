import React, { useState, useEffect } from 'react'

import { Paper, Typography, Box } from '@mui/material';

import Sidebar from '../../components/sidebar/sidebar'

import CampanhaService from "../../service/campanha.js";

const CampanhasArquivadas = () => {
    const [aba, setAba] = useState("mestre");
    const [campanhas, setCampanhas] = useState([]);

    useEffect(() => {
        const id = JSON.parse(localStorage.getItem("userId"));
        CampanhaService.getAllArquivadas(id).then((response) => {
            console.log("campanhas: ", response);
            setCampanhas(response);
        })
    }, []);

    const getNovaDataSessao = (data) => {
        return new Date(data).toLocaleDateString('pt-BR', { timeZone: 'UTC' });
    }

    return (
        <Sidebar aba={aba} setAba={setAba}>
            <Box className='mt-10'>
                {
                    (campanhas?.map((campanha, index) => {
                        return (
                            <Paper key={index} className='grid grid-cols-4 gap-6 items-center p-4 cursor-pointer transition duration-300 hover:opacity-95 hover:transition hover:duration-300 mb-4' sx={{ borderLeft: '10px solid', borderColor: 'secondary.main' }}>
                                <Box className='flex items-center w-12 h-12'>
                                    <img className="w-full h-full" src={"data:" + campanha.mapa.arquivo.tipo + ";base64," + campanha.mapa.arquivo.dados} alt="Campanha imagem" />
                                </Box>
                                <Typography fontSize='22px' color='text.white'>{campanha.nome}</Typography>
                                <Typography fontSize='22px' color='text.white'>Jogadores: {campanha.personagem.length}</Typography>
                                <Typography fontSize='22px' color='text.white'>Última Sessão: {campanha.proxima_sessao ? getNovaDataSessao(campanha.proxima_sessao.slice(0, 10).replaceAll("-", "/")) : " A  definir"}</Typography>
                            </Paper>
                        )

                    }))}
            </Box>
        </Sidebar>
    )
}

export default CampanhasArquivadas
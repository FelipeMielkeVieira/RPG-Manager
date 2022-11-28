import React, { useState, useEffect } from 'react'

import { Box, Button, Divider, Typography } from '@mui/material';

import MapaService from '../../service/mapa.js';
import SistemaService from '../../service/sistema.js';
import CampanhaService from '../../service/campanha.js';

import Sidebar from '../../components/sidebar/sidebar'
import UploadArquivoCinza from "../../img/uploadArquivoCinza.png"

const CriarCampanha = () => {
    const [aba, setAba] = useState("mestre");
    const [nome, setNome] = useState("");
    const [descricao, setDescricao] = useState("");
    const [mapa, setMapa] = useState("");
    const [sistema, setSistema] = useState("");

    const [imagem, setImagem] = useState(UploadArquivoCinza);
    const [mapas, setMapas] = useState([]);
    const [sistemas, setSistemas] = useState([]);

    useEffect(() => {
        MapaService.getAll().then((response) => {
            console.log("mapa: ", response.data);
            setMapas(response.data);
        })

        SistemaService.getAll().then((response) => {
            console.log("sistema: ", response);
            setSistemas(response);
        })
    }, []);

    const criarCampanha = () => {
        const emailUser = JSON.parse(localStorage.getItem("email-user"));
        const logo = document.getElementById('input-file').files[0];
        
        CampanhaService.post({
            campanha:
                { nome, descricao, usuario: { email: emailUser }, sistema: { id: sistema }, arquivada: false },
            logo,
            mapa
        }).then((response) => {
            console.log("response: ", response);
            setNome("");
            setDescricao("");
            setMapa("");
            setSistema("");
            setImagem(UploadArquivoCinza);
        });
    }

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
                                <Box value={nome} onChange={(e) => setNome(e.target.value)} component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} placeholder='Nome da campanha' />
                            </label>
                            <label>
                                Descrição
                                <Box value={descricao} onChange={(e) => setDescricao(e.target.value)} component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} placeholder='Descrição da campanha' />
                            </label>
                            <label>
                                Mapa
                                <Box value={mapa} onChange={(e) => { setMapa(e.target.value) }} component="select" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} >
                                    {mapas.map((mapa, index) => {
                                        return <option key={index} value={mapa.id}>{mapa.arquivo.nome}</option>
                                    })}
                                </Box>
                            </label>
                            <label>
                                Sistema utlizado
                                <Box value={sistema} onChange={(e) => { setSistema(e.target.value) }} component="select" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} >
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
                                <input id='input-file' type="file" hidden
                                    onChange={() => {
                                        setImagem(URL.createObjectURL(document.getElementById('input-file').files[0]));
                                    }} />
                                <Box className='flex justify-center items-center w-full h-72 border rounded'>
                                    <img src={imagem} className='w-10/12 h-11/12 ' />
                                </Box>
                            </label>
                        </Box>
                    </Box>
                    <Box className='flex justify-end mt-12'>
                        <Button onClick={criarCampanha} variant='contained' color='secondary' sx={{ color: "white" }} disableElevation>Criar campanha</Button>
                    </Box>
                </Box>
            </Box>
        </Sidebar>
    )
}

export default CriarCampanha
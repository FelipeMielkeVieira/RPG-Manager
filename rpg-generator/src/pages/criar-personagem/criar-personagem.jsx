import React, { useState } from 'react'

import { Box, Button, Divider, Typography } from '@mui/material'

import Sidebar from '../../components/sidebar/sidebar'
import UploadArquivoCinza from "../../img/uploadArquivoCinza.png"

const CriarPersonagem = () => {
    const [aba, setAba] = useState("jogador");

    const [nome, setNome] = useState("");
    const [vida, setVida] = useState("");
    const [mana, setMana] = useState("");
    const [nivel, setNivel] = useState("");
    const [imagem, setImagem] = useState(UploadArquivoCinza);

    const savePersonagem = () => {
        
    }

    const clearData = () => {
        setNome("");
        setVida("");
        setMana("");
        setNivel("");
        setImagem(UploadArquivoCinza);
    }

    return (
        <Sidebar aba={aba} setAba={setAba}>
            <Box p='2rem 3rem'>
                <Box className='flex gap-12'>
                    <Typography variant='h5' color='text.secondary'>Criar personagem</Typography>
                </Box>
                <Divider sx={{ borderWidth: '1px' }} />

                <Box className='flex w-full pt-4'>
                    <Box className='w-2/4'>

                        <label>
                            Nome
                            <Box value={nome} onChange={(e) => setNome(e.target.value)} component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} />
                        </label>
                        <label>
                            Vida
                            <Box value={vida} onChange={(e) => setVida(e.target.value)} component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} />
                        </label>
                        <label>
                            Mana
                            <Box value={mana} onChange={(e) => setMana(e.target.value)} component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} />
                        </label>

                        <label>
                            Nível
                            <Box value={nivel} onChange={(e) => setNivel(e.target.value)} component="input" className='w-full h-12 border-2 border-l-4 border-gray-300 rounded p-2 outline-none' sx={{ borderLeftColor: "secondary.main" }} />
                        </label>
                    </Box>
                    <Box className='flex justify-center items-center w-2/4'>
                        <Box className='w-3/4'>

                            <label className='w-full'>
                                Arquivo
                                <input id='input-file' type="file" hidden
                                    onChange={() => {
                                        setImagem(URL.createObjectURL(document.getElementById('input-file').files[0]));
                                    }} />
                                <Box className='flex justify-center items-center w-full border rounded'>
                                    <img src={imagem} className='w-10/12 h-11/12 ' />
                                </Box>
                            </label>
                        </Box>
                    </Box>
                </Box>
                <Box className='w-full flex justify-end mt-10'>
                    <Button onClick={() => { savePersonagem(); clearData(); }} color="secondary" variant="contained" disableElevation>Criar</Button>
                </Box>

            </Box>
        </Sidebar>
    )
}

export default CriarPersonagem
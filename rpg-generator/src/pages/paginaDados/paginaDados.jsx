import React, { useState, useEffect } from 'react'

import { Box, Typography, Divider, TextField, Select, SelectChangeEvent, MenuItem, FormControl, InputLabel, Button, Grid, Paper } from '@mui/material';
import Sidebar from '../../components/sidebar/sidebar'

const PaginaDados = () => {
    const [aba, setAba] = useState("jogador");
    const [dados, setDados] = useState({ qtd: 1, lados: 4 });
    const [dadosSalvos, setDadosSalvos] = useState([]);

    const saveInput = (numInput, e) => {
        if (numInput == 1) {
            setDados({ ...dados, qtd: e.target.value });
        } else {
            setDados({ ...dados, lados: e.target.value });
        }
    }

    const rodarDado = () => {
        let listaDados = [];
        for (let i = 1; i <= dados.qtd; i++) {
            listaDados.push({id: i, numero: gerarNumero(1, dados.lados)});
        }
        setDadosSalvos(listaDados);
    }

    const gerarNumero = (min, max) => {
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    return (
        <Sidebar aba={aba} setAba={setAba}>
            <Box p='2rem 3rem'>
                <Box className='flex gap-12'>
                    <Typography className='cursor-pointer' variant='h4' color='text.secondary'>Dados</Typography>
                </Box>
                <Divider sx={{ borderWidth: '1px' }} />
                <Box p='3rem 0rem' className='flex flex-col items-center justify-center'>
                    <Typography variant='h4' color='text.black'>
                        Insira as informações abaixo para rodar um dado
                    </Typography>
                    <Box p='3rem 0rem' className='flex'>
                        <TextField sx={{ marginRight: '2rem' }} onChange={(e) => { saveInput(1, e) }} value={dados.qtd} id="filled-basic-size-big" label="Qtd de Dados" variant="filled" />
                        <FormControl variant="filled" sx={{ minWidth: 120 }}>
                            <InputLabel id="demo-simple-select-label">Lados</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={dados.lados}
                                onChange={(a) => { saveInput(2, a) }}
                            >
                                <MenuItem sx={{ color: 'white' }} value={4}>D4</MenuItem>
                                <MenuItem sx={{ color: 'white' }} value={6}>D6</MenuItem>
                                <MenuItem sx={{ color: 'white' }} value={8}>D8</MenuItem>
                                <MenuItem sx={{ color: 'white' }} value={12}>D12</MenuItem>
                                <MenuItem sx={{ color: 'white' }} value={20}>D20</MenuItem>
                                <MenuItem sx={{ color: 'white' }} value={100}>D100</MenuItem>
                            </Select>
                        </FormControl>
                    </Box>
                    <Button variant='contained' size='large' onClick={rodarDado}>
                        Girar
                    </Button>
                    <Box p='4rem 0rem'>
                        <Grid container spacing={8}>
                            {dadosSalvos.map((dado) => (
                                <Grid key={dado.id} item xs={2}>
                                    <Typography variant='h6' color='text.black'>{dado.numero}</Typography>
                                </Grid>
                            ))}
                        </Grid>
                    </Box>
                </Box>
            </Box>
        </Sidebar>
    )
}

export default PaginaDados;
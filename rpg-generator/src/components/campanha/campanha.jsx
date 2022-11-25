import React from 'react'

import { Paper, Typography } from '@mui/material';

const Campanha = (props) => {
    const campanha = props.campanha;

    return (
        <Paper className='flex justify-around p-4 cursor-pointer transition duration-300 hover:opacity-95 hover:transition hover:duration-300' sx={{borderLeft: '10px solid', borderColor: 'secondary.main'}}>
            <Typography fontSize='22px' color='text.white'>{campanha.nome}</Typography>
            <Typography fontSize='22px' color='text.white'>{campanha.criador}</Typography>
            <Typography fontSize='22px' color='text.white'>{campanha.data}</Typography>
        </Paper>
    )
}

export default Campanha
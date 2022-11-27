import React from 'react'

import { Typography } from '@mui/material';

import ItemListModel from '../item-list-model/item-list-model';

const Campanha = (props) => {
    const campanha = props.campanha;

    return (
        <ItemListModel>
            <Typography fontSize='22px' color='text.white'>{campanha.nome}</Typography>
            <Typography fontSize='22px' color='text.white'>{campanha.criador}</Typography>
            <Typography fontSize='22px' color='text.white'>{campanha.data}</Typography>
        </ItemListModel>
    )
}

export default Campanha
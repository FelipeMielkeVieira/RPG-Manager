import React, { useState } from 'react'

import { Box } from '@mui/material'

import Sidebar from '../../components/sidebar/sidebar'

const Sistemas = () => {
    const [aba, setAba] = useState("mestre");

    return (
        <Sidebar aba={aba} setAba={setAba}>
            <Box p='2rem 3rem'>
                
            </Box>
        </Sidebar>
    )
}

export default Sistemas
import React from 'react'
import { useNavigate } from 'react-router-dom';

import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';

import Historia from "../../img/historia.png";
import Dados from "../../img/dados.png";
import Mapa from "../../img/mapa.png"
import Sistemas from "../../img/sistema.png";

const ListaSidebar = (props) => {
    const navigate = useNavigate();
    const open = props.open;

    return (
        <List>
            <ListItem onClick={() => navigate("/campanhas-arquivadas")} disablePadding sx={{ display: 'block', paddingTop: '1rem' }}>
                <ListItemButton sx={{
                    minHeight: 48,
                    justifyContent: open ? 'initial' : 'center',
                    px: 2.5,
                }}>
                    <ListItemIcon
                        sx={{
                            minWidth: 0,
                            mr: open ? 3 : 'auto',
                            justifyContent: 'center',
                        }}
                    >
                        <img className='h-10' src={Historia} />
                    </ListItemIcon>
                    <ListItemText disableTypography primary="Campanhas arquivadas" sx={{ opacity: open ? 1 : 0, color: "text.white" }} />
                </ListItemButton>
            </ListItem>

            <ListItem onClick={() => navigate("/dados")} disablePadding sx={{ display: 'block' }}>
                <ListItemButton sx={{
                    minHeight: 48,
                    justifyContent: open ? 'initial' : 'center',
                    px: 2.5,
                }}>
                    <ListItemIcon
                        sx={{
                            minWidth: 0,
                            mr: open ? 3 : 'auto',
                            justifyContent: 'center',
                        }}
                    >
                        <img className='h-10' src={Dados} />
                    </ListItemIcon>
                    <ListItemText disableTypography primary="Dados" sx={{ opacity: open ? 1 : 0, color: "text.white" }} />
                </ListItemButton>
            </ListItem>

            <ListItem onClick={() => navigate("/mapas")} disablePadding sx={{ display: 'block' }}>
                <ListItemButton sx={{
                    minHeight: 48,
                    justifyContent: open ? 'initial' : 'center',
                    px: 2.5,
                }}>
                    <ListItemIcon
                        sx={{
                            minWidth: 0,
                            mr: open ? 3 : 'auto',
                            justifyContent: 'center',
                        }}
                    >
                        <img className='h-10' src={Mapa} />
                    </ListItemIcon>
                    <ListItemText disableTypography primary="Mapas" sx={{ opacity: open ? 1 : 0, color: "text.white" }} />
                </ListItemButton>
            </ListItem>
        </List>
    )
}

export default ListaSidebar
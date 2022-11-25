import React, { useState } from 'react'

import Sidebar from '../../components/sidebar/sidebar'
import ConteudoJogador from '../../components/conteudo-jogador/conteudo-jogador';

const Home = () => {
    const [aba, setAba] = useState("jogador");

    return (
        <Sidebar aba={aba} setAba={setAba}>
                {aba === "jogador" && <ConteudoJogador />}
                {aba === "mestre" && <div>Home Mestre</div>}
        </Sidebar>
    )
}

export default Home
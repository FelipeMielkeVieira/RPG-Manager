import React, { useState } from 'react'

import Sidebar from '../../components/sidebar/sidebar'
import ConteudoJogador from '../../components/conteudo-jogador/conteudo-jogador';
import ConteudoMestre from '../../components/conteudo-mestre/conteudo-mestre';

const Home = () => {
    const [aba, setAba] = useState("jogador");

    return (
        <Sidebar aba={aba} setAba={setAba}>
                {aba === "jogador" && <ConteudoJogador />}
                {aba === "mestre" && <ConteudoMestre />}
        </Sidebar>
    )
}

export default Home
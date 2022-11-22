package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Mapa;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.entities.Sessao;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class CampanhaDTO {
    private String nome;
    private String descricao;
    private Usuario usuario;
    private List<Personagem> personagem;
}

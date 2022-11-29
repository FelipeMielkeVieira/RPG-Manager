package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Imagem;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.entities.Sessao;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class CampanhaFullDTO {
    private String nome;
    private Date proxima_sessao;
    private String descricao;
    private Boolean arquivada;
    private Usuario usuario;
    private List<Personagem> personagem;
    private List<Sessao> sessao;
}

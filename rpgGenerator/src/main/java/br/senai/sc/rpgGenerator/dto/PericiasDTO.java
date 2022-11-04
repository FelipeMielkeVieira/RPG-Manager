package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
public class PericiasDTO {
    private Integer acrobacia;
    private Integer arcanismo;
    private Integer atletismo;
    private Integer atuacao;
    private Integer enganacao;
    private Integer furtividade;
    private Integer historia;
    private Integer intimidacao;
    private Integer intuicao;
    private Integer investigacao;
    private Integer lidar_animais;
    private Integer medicina;
    private Integer natureza;
    private Integer percepcao;
    private Integer persuasao;
    private Integer prestigiacao;
    private Integer religiao;
    private Integer sobrevivencia;
//    private Personagem personagem;
}

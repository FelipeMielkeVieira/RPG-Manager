package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.*;
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
    private Boolean arquivada;
//    private Mapa mapa;
//    private List<Personagem> personagem;
}

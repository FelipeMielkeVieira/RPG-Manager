package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
public class AtaqueDTO {
    private String nome;
    private String tipo;
    private Integer dano_minimo;
    private Integer dano_maximo;
//    private Personagem personagem;
}

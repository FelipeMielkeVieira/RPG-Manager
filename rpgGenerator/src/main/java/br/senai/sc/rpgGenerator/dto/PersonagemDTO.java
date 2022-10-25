package br.senai.sc.rpgGenerator.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
public class PersonagemDTO {
    private Long id;
//    private Integer nivel;
    private String nome;
    private Integer mana;
    private Integer vida;
    private String classe;
    private String raca;
    private String antecedente;
    private String alinhamento;
    private Integer expAtual;
    private Integer expProximo;
    private Byte imagem;
}

package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Campanha;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
public class PersonagemDTO {
    private Integer nivel;
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
    private Usuario usuario;
    private Campanha campanha;
}

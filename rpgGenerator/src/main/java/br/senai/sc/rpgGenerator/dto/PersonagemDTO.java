package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.*;
import lombok.*;

import java.util.List;

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
    private Imagem imagem;
    //    private Usuario usuario;
//    private Campanha campanha;
    private List<Organizacao> organizaoes;
    private List<Aliado> aliados;
    private List<Equipamento> equipamentos;
    private List<Ataque> ataques;
    private Tracos tracos;
}

package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Personagem {
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

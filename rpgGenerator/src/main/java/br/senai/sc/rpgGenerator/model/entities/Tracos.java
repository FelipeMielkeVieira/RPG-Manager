package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tracos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tracos {
    private Long id;
    private Integer idade;
    private String corOlho;
    private Double altura;
    private String corPele;
    private Double peso;
    private String corCabelo;
    private String personalidade;
    private String ideais;
    private String fraquezas;
    private Personagem personagem;
}

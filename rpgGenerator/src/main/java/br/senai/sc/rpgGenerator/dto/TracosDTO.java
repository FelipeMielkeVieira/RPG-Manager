package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
public class TracosDTO {
    private Integer idade;
    private String corOlho;
    private Double altura;
    private String corPele;
    private Double peso;
    private String corCabelo;
    private String personalidade;
    private String ideais;
    private String fraquezas;
//    private Personagem personagem;
}

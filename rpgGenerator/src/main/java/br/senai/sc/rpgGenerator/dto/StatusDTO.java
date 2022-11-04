package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
public class StatusDTO {
    private Integer forca;
    private Integer destreza;
    private Integer constituicao;
    private Integer inteligencia;
    private Integer sabedoria;
    private Integer carisma;
    private Integer bonusProficiencia;
    private Integer inspiracao;
    private Integer armadura;
    private Integer iniciativa;
    private Integer deslocamento;
    private Integer percepcao;
//    private Personagem personagem;
}

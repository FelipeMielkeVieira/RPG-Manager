package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
public class AliadoDTO {
    private Integer aliado_id;
    private Personagem personagem;
}

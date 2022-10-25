package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Status {
    private Long id;
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
}

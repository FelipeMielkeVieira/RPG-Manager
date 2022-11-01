package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "extraspersonagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ExtrasPersonagem {
    private Long id;
    private String talentos;
    private String idiomas;
    private String historia;
    private Personagem personagem;
}

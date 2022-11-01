package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "organizacao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Organizacao {
    private Long id;
    private String nome;
    private Personagem personagem;
}

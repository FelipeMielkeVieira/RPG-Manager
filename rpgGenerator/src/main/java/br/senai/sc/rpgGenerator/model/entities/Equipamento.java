package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "equipamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Equipamento {
    private Long id;
    private String nome;
    private Integer bonus;
    private Integer tipo;
    private Personagem personagem;
}

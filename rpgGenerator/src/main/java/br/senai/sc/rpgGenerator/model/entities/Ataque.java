package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ataque")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Ataque {
    private Long id;
    private String nome;
    private String tipo;
    private Integer dano_minimo;
    private Integer dano_maximo;
    private Personagem personagem;
}

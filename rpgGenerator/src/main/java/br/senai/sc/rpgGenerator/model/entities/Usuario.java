package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Usuario {
    private String email;
    private String nome;
    private String senha;
    private Byte imagem;
}

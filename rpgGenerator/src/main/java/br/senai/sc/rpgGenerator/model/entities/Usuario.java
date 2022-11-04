package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 30)
    private String senha;

    @Column
    private Imagem imagem;

    @OneToMany
    @JoinColumn(name = "campanha_id")
    private List<Campanha> campanha;

    @OneToMany
    @JoinColumn(name = "personagem_id")
    private List<Personagem> personagens;
}

package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String talentos;

    @Column(nullable = false, length = 200)
    private String idiomas;

    @Column(nullable = false, length = 1000)
    private String historia;

//    private Personagem personagem;
}

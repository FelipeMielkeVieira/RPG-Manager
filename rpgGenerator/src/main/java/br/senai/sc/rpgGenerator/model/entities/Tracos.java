package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tracos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tracos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, length = 50)
    private String corOlho;

    @Column(nullable = false)
    private Double altura;

    @Column(nullable = false, length = 50)
    private String corPele;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false, length = 50)
    private String corCabelo;

    @Column(length = 400)
    private String personalidade;

    @Column(length = 400)
    private String ideais;

    @Column(length = 400)
    private String fraquezas;

//    private Personagem personagem;
}

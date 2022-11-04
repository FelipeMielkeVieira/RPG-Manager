package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer forca;

    @Column(nullable = false)
    private Integer destreza;

    @Column(nullable = false)
    private Integer constituicao;

    @Column(nullable = false)
    private Integer inteligencia;

    @Column(nullable = false)
    private Integer sabedoria;

    @Column(nullable = false)
    private Integer carisma;

    @Column(nullable = false)
    private Integer bonusProficiencia;

    @Column(nullable = false)
    private Integer inspiracao;

    @Column(nullable = false)
    private Integer armadura;

    @Column(nullable = false)
    private Integer iniciativa;

    @Column(nullable = false)
    private Integer deslocamento;

    @Column
    private Integer percepcao;
//    private Personagem personagem;
}

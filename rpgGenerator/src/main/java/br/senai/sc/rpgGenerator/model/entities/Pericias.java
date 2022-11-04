package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pericias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pericias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer acrobacia;

    @Column(nullable = false)
    private Integer arcanismo;

    @Column(nullable = false)
    private Integer atletismo;

    @Column(nullable = false)
    private Integer atuacao;

    @Column(nullable = false)
    private Integer enganacao;

    @Column(nullable = false)
    private Integer furtividade;

    @Column(nullable = false)
    private Integer historia;

    @Column(nullable = false)
    private Integer intimidacao;

    @Column(nullable = false)
    private Integer intuicao;

    @Column(nullable = false)
    private Integer investigacao;

    @Column(nullable = false)
    private Integer lidar_animais;

    @Column(nullable = false)
    private Integer medicina;

    @Column(nullable = false)
    private Integer natureza;

    @Column(nullable = false)
    private Integer percepcao;

    @Column(nullable = false)
    private Integer persuasao;

    @Column(nullable = false)
    private Integer prestigiacao;

    @Column(nullable = false)
    private Integer religiao;

    @Column(nullable = false)
    private Integer sobrevivencia;

//    private Personagem personagem;
}

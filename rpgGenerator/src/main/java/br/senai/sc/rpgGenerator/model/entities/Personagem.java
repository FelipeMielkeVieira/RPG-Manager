package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column
    private Integer mana;

    @Column(nullable = false)
    private Integer vida;

    @Column(nullable = false, length = 50)
    private String classe;

    @Column(nullable = false, length = 50)
    private String raca;

    @Column(length = 50)
    private String antecedente;

    @Column(nullable = false, length = 50)
    private String alinhamento;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer expAtual;

    @Column(nullable = false)
    private Integer expProximo;

    @Column
    private Imagem imagem;

    @OneToMany
    @JoinColumn(name = "vinculo_id")
    private List<Vinculo> vinculo;

    @OneToOne
    @JoinColumn(name = "salvaguarda_id")
    private Salvaguarda salvaguarda;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToOne
    @JoinColumn(name = "pericias_id")
    private Pericias pericias;

    @OneToOne
    @JoinColumn(name = "extaras_personagem_id")
    private ExtrasPersonagem extrasPersonagem;

    @OneToMany
    @JoinColumn(name = "organizacao_id")
    private List<Organizacao> organizaoes;

    @OneToMany
    @JoinColumn(name = "aliado_id")
    private List<Aliado> aliados;

    @OneToMany
    @JoinColumn(name = "equipamento_id")
    private List<Equipamento> equipamentos;

    @OneToMany
    @JoinColumn(name = "ataque_id")
    private List<Ataque> ataques;

    @OneToOne
    @JoinColumn(name = "tracos_id")
    private Tracos tracos;

//    private Usuario usuario;
//    private Campanha campanha;
}

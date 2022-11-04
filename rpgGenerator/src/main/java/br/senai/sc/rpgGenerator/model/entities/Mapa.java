package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "mapa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Mapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Lob
    @NonNull
    private byte[] mapa;

//    private Campanha campanha;
}

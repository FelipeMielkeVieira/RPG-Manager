package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "mapa")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Mapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 100)
    private String nome;

    @NonNull
    private String tipo;

    @Lob
    @NonNull
    private byte[] dados;

//    private Campanha campanha;
}

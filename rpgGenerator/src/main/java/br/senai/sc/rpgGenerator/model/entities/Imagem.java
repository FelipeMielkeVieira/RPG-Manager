package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
    @Table(name = "imagem")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String tipo;

    @Lob
    @NonNull
    private byte[] dados;
}

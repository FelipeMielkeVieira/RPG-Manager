package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "arquivo")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Arquivo {

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

package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sistema")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Sistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "usuario_email")
    private Usuario usuario;
}

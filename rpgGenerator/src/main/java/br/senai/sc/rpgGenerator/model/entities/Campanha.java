package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "campanha")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Campanha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column
    private Date proxima_sessao;

    @Column(nullable = false, length = 400)
    private String descricao;

//    @ManyToOne
//    @JoinColumn(name = "usuario_email")
//    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "personagem_id")
    private List<Personagem> personagem;

    @OneToMany
    @JoinColumn(name = "sessao_id")
    private List<Sessao> sessao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mapa_id")
    private List<Mapa> mapas;

    public void setMapa(MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                this.mapas.add(new Mapa(file.getOriginalFilename(), file.getContentType(), file.getBytes()));
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}

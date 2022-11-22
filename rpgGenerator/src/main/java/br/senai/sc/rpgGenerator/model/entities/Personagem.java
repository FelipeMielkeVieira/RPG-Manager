package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer expAtual;

    @Column(nullable = false)
    private Integer expProximo;

    @OneToMany
    @JoinColumn(name = "personagem_id")
    private List<Arquivo> arquivos;

    @ManyToOne
    @JoinColumn(name = "campanha_id")
    private Campanha campanha;

    public void setArquivos(List<MultipartFile> files) {
        List<Arquivo> listaArquivos = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                listaArquivos.add(new Arquivo(file.getOriginalFilename(), file.getContentType(), file.getBytes()));
            }
            this.arquivos = listaArquivos;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

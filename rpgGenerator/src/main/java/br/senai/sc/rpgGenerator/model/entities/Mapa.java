package br.senai.sc.rpgGenerator.model.entities;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arquivo_id", nullable = false)
    private Arquivo arquivo;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "usuario_email", nullable = false)
    private Usuario usuario;

    public void setArquivo(MultipartFile file) {
        try {
            this.arquivo = new Arquivo(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

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

    @OneToOne(cascade = CascadeType.ALL)
    private Arquivo arquivo;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "usuario_email")
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

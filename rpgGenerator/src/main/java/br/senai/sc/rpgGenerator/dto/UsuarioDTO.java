package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Campanha;
import br.senai.sc.rpgGenerator.model.entities.Imagem;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.awt.*;
import java.util.List;

@Getter
@Setter
@ToString
public class UsuarioDTO {
    private String nome;
    private String senha;
    private Imagem imagem;
    private List<Campanha> campanha;
    private List<Personagem> personagens;
}

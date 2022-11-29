package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class PersonagemDTO {
    private Integer nivel;
    private String nome;
    private Integer mana;
    private Integer vida;
    private Usuario usuario;
}

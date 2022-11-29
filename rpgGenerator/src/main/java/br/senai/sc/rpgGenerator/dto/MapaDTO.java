package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Arquivo;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MapaDTO {
    private Arquivo arquivo;
    private Usuario usuario;
}

package br.senai.sc.rpgGenerator.dto;

import br.senai.sc.rpgGenerator.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
public class SistemaDTO {
    private String nome;
    private String descricao;
    private Date date;
    private Usuario usuario;
}

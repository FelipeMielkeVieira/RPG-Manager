package br.senai.sc.rpgGenerator.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
public class UsuarioDTO {
    private String nome;
    private String senha;
    private Byte imagem;
}

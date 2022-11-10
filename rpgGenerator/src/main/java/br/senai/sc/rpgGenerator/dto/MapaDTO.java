package br.senai.sc.rpgGenerator.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MapaDTO {
    private String nome;
    private String tipo;
    private byte[] dados;
}

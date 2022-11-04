package br.senai.sc.rpgGenerator.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@ToString
public class SessaoDTO {
    private String descricao;
    private Date date;
}

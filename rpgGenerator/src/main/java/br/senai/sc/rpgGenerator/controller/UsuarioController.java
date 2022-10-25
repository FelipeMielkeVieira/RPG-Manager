package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.model.service.UsuarioService;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Controller
@RequestMapping("rpg-generator/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
}

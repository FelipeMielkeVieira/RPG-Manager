package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.model.service.TracosService;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Controller
@RequestMapping("rpg-generator/tracos")
public class TracosController {
    private TracosService tracosService;
}

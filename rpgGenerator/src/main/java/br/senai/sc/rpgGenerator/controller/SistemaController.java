package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.model.entities.Sistema;
import br.senai.sc.rpgGenerator.model.service.SistemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@AllArgsConstructor
@RequestMapping("rpg_manager/sistema")
public class SistemaController {
    private SistemaService sistemaService;

    @GetMapping
    public ResponseEntity<List<Sistema>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(sistemaService.findAll());
    }
}

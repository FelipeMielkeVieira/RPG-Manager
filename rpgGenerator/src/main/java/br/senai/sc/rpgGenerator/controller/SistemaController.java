package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.SistemaDTO;
import br.senai.sc.rpgGenerator.model.entities.Sistema;
import br.senai.sc.rpgGenerator.model.service.SistemaService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid SistemaDTO sistemaDTO) {
        System.out.println(sistemaDTO.toString());
        Sistema sistema = new Sistema();
        BeanUtils.copyProperties(sistemaDTO, sistema);

        return ResponseEntity.status(HttpStatus.CREATED).body(sistemaService.save(sistema));
    }
}

package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.StatusDTO;
import br.senai.sc.rpgGenerator.dto.TracosDTO;
import br.senai.sc.rpgGenerator.model.entities.Status;
import br.senai.sc.rpgGenerator.model.entities.Tracos;
import br.senai.sc.rpgGenerator.model.service.TracosService;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("rpg-generator/tracos")
public class TracosController {
    private TracosService tracosService;

    @GetMapping
    public ResponseEntity<List<Tracos>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(tracosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!tracosService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o traço!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(tracosService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TracosDTO tracosDTO){
        Tracos tracos = new Tracos();
        BeanUtils.copyProperties(tracosDTO, tracos);
        return ResponseEntity.status(HttpStatus.CREATED).body(tracosService.save(tracos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid TracosDTO tracosDTO){
        if (!tracosService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este traço não existe.");
        }

        Tracos tracos = new Tracos();
        BeanUtils.copyProperties(tracosDTO, tracos);
        tracos.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(tracosService.save(tracos));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!tracosService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o traço!");
        }

        tracosService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Traços deletado com sucesso!");
    }
}

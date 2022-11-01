package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.PersonagemDTO;
import br.senai.sc.rpgGenerator.model.entities.Aliado;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.service.AliadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

public class AliadoController {
    private AliadoService aliadoService;

    @GetMapping
    public ResponseEntity<List<Aliado>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(aliadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!aliadoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o aliado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(aliadoService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AliadoDTO aliadoDTO){
        Aliado aliado = new Aliado();
        BeanUtils.copyProperties(aliadoDTO, aliado);
        return ResponseEntity.status(HttpStatus.CREATED).body(aliadoService.save(aliado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid AliadoDTO aliadoDTO){
        if (!aliadoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este aliado não existe.");
        }

        Aliado aliado = new Aliado();
        BeanUtils.copyProperties(aliadoDTO, aliado);
        aliado.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(aliadoService.save(aliado));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!aliadoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o aliado!");
        }

        aliadoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aliado deletado com sucesso!");
    }
}

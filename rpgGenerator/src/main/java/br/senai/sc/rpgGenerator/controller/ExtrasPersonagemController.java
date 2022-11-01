package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.ExtrasPersonagemDTO;
import br.senai.sc.rpgGenerator.model.entities.ExtrasPersonagem;
import br.senai.sc.rpgGenerator.model.service.ExtrasPersonagemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("rpg-generator/extras-personagem")
public class ExtrasPersonagemController {
    private ExtrasPersonagemService extrasPersonagemService;

    @GetMapping
    public ResponseEntity<List<ExtrasPersonagem>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(extrasPersonagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!extrasPersonagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar os extras do personagem!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(extrasPersonagemService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ExtrasPersonagemDTO extrasPersonagemDTO){
        ExtrasPersonagem extrasPersonagem = new ExtrasPersonagem();
        BeanUtils.copyProperties(extrasPersonagemDTO, extrasPersonagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(extrasPersonagemService.save(extrasPersonagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid ExtrasPersonagemDTO extrasPersonagemDTO){
        if (!extrasPersonagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estes extras do personagem não existem.");
        }

        ExtrasPersonagem extrasPersonagem = new ExtrasPersonagem();
        BeanUtils.copyProperties(extrasPersonagemDTO, extrasPersonagem);
        extrasPersonagem.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(extrasPersonagemService.save(extrasPersonagem));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!extrasPersonagemService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar os extras do personagem!");
        }

        extrasPersonagemService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Extras do personagem deletado com sucesso!");
    }
}

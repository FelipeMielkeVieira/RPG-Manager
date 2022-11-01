package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.AtaqueDTO;
import br.senai.sc.rpgGenerator.dto.PersonagemDTO;
import br.senai.sc.rpgGenerator.model.entities.Ataque;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.service.AtaqueService;
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
@RequestMapping("rpg-generator/ataque")
public class AtaqueController {
    private AtaqueService ataqueService;

    @GetMapping
    public ResponseEntity<List<Ataque>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(ataqueService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!ataqueService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o ataque!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(ataqueService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AtaqueDTO ataqueDTO){
        Ataque ataque = new Ataque();
        BeanUtils.copyProperties(ataqueDTO, ataque);
        return ResponseEntity.status(HttpStatus.CREATED).body(ataqueService.save(ataque));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid AtaqueDTO ataqueDTO){
        if (!ataqueService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este ataque não existe.");
        }

        Ataque ataque = new Ataque();
        BeanUtils.copyProperties(ataqueDTO, ataque);
        ataque.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ataqueService.save(ataque));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!ataqueService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o ataque!");
        }

        ataqueService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ataque deletado com sucesso!");
    }
}

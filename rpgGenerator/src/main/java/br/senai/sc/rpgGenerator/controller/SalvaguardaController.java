package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.PersonagemDTO;
import br.senai.sc.rpgGenerator.dto.SalvaguardaDTO;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.entities.Salvaguarda;
import br.senai.sc.rpgGenerator.model.service.SalvaguardaService;
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
@RequestMapping("rpg-manager/salvaguarda")
public class SalvaguardaController {
    private SalvaguardaService salvaguardaService;

    @GetMapping
    public ResponseEntity<List<Salvaguarda>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(salvaguardaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!salvaguardaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a salva guarda!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(salvaguardaService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid SalvaguardaDTO salvaguardaDTO){
        Salvaguarda salvaguarda = new Salvaguarda();
        BeanUtils.copyProperties(salvaguardaDTO, salvaguarda);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaguardaService.save(salvaguarda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid SalvaguardaDTO salvaguardaDTO){
        if (!salvaguardaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta salva guarda não existe.");
        }

        Salvaguarda salvaguarda = new Salvaguarda();
        BeanUtils.copyProperties(salvaguardaDTO, salvaguarda);
        salvaguarda.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(salvaguardaService.save(salvaguarda));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!salvaguardaService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a salva guarda!");
        }

        salvaguardaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Salva guarda deletada com sucesso!");
    }
}

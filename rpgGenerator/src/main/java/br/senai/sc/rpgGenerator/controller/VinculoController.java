package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.VinculoDTO;
import br.senai.sc.rpgGenerator.model.entities.Vinculo;
import br.senai.sc.rpgGenerator.model.service.VinculoService;
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
@RequestMapping("rpg-manager/vinculo")
public class VinculoController {
    private VinculoService vinculoService;

    @GetMapping
    public ResponseEntity<List<Vinculo>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(vinculoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!vinculoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o vínculo!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(vinculoService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid VinculoDTO vinculoDTO){
        Vinculo vinculo = new Vinculo();
        BeanUtils.copyProperties(vinculoDTO, vinculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(vinculoService.save(vinculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid VinculoDTO vinculoDTO){
        if (!vinculoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este vínculo não existe.");
        }

        Vinculo vinculo = new Vinculo();
        BeanUtils.copyProperties(vinculoDTO, vinculo);
        vinculo.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(vinculoService.save(vinculo));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!vinculoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o vínculo!");
        }

        vinculoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Vínculo deletado com sucesso!");
    }
}

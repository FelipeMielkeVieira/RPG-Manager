package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.OrganizacaoDTO;
import br.senai.sc.rpgGenerator.dto.PericiasDTO;
import br.senai.sc.rpgGenerator.model.entities.Organizacao;
import br.senai.sc.rpgGenerator.model.entities.Pericias;
import br.senai.sc.rpgGenerator.model.service.PericiasService;
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
@RequestMapping("rpg-generator/pericias")
public class PericiasController {
    private PericiasService periciasService;

    @GetMapping
    public ResponseEntity<List<Pericias>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(periciasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!periciasService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a perícia!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(periciasService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PericiasDTO periciasDTO){
        Pericias pericias = new Pericias();
        BeanUtils.copyProperties(periciasDTO, pericias);
        return ResponseEntity.status(HttpStatus.CREATED).body(periciasService.save(pericias));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid PericiasDTO periciasDTO){
        if (!periciasService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta organização não existe.");
        }

        Pericias pericias = new Pericias();
        BeanUtils.copyProperties(periciasDTO, pericias);
        pericias.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(periciasService.save(pericias));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!periciasService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a perícia!");
        }

        periciasService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Perícia deletada com sucesso!");
    }
}

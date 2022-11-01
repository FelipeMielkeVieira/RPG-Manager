package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.AtaqueDTO;
import br.senai.sc.rpgGenerator.dto.OrganizacaoDTO;
import br.senai.sc.rpgGenerator.model.entities.Ataque;
import br.senai.sc.rpgGenerator.model.entities.Organizacao;
import br.senai.sc.rpgGenerator.model.service.OrganizacaoService;
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
@RequestMapping("rpg-generator/organizacao")
public class OrganizacaoController {
    private OrganizacaoService organizacaoService;

    @GetMapping
    public ResponseEntity<List<Organizacao>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(organizacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!organizacaoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a organização!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(organizacaoService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid OrganizacaoDTO organizacaoDTO){
        Organizacao organizacao = new Organizacao();
        BeanUtils.copyProperties(organizacaoDTO, organizacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(organizacaoService.save(organizacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid OrganizacaoDTO organizacaoDTO){
        if (!organizacaoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta organização não existe.");
        }

        Organizacao organizacao = new Organizacao();
        BeanUtils.copyProperties(organizacaoDTO, organizacao);
        organizacao.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(organizacaoService.save(organizacao));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!organizacaoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a organização!");
        }

        organizacaoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Organização deletada com sucesso!");
    }
}

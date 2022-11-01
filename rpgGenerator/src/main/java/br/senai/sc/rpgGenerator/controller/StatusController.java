package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.StatusDTO;
import br.senai.sc.rpgGenerator.model.entities.Status;
import br.senai.sc.rpgGenerator.model.service.StatusService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("rpg-generator/status")
public class StatusController {
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(statusService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!statusService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o status!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(statusService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid StatusDTO statusDTO){
        Status status = new Status();
        BeanUtils.copyProperties(statusDTO, status);
        return ResponseEntity.status(HttpStatus.CREATED).body(statusService.save(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid StatusDTO statusDTO){
        if (!statusService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este status não existe.");
        }
        Status status = new Status();
        BeanUtils.copyProperties(statusDTO, status);
        status.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(statusService.save(status));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!statusService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o status!");
        }

        statusService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Status deletado com sucesso!");
    }
}

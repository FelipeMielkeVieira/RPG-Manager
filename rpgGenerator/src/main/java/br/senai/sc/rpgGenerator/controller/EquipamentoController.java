package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.CampanhaDTO;
import br.senai.sc.rpgGenerator.dto.EquipamentoDTO;
import br.senai.sc.rpgGenerator.model.entities.Campanha;
import br.senai.sc.rpgGenerator.model.entities.Equipamento;
import br.senai.sc.rpgGenerator.model.service.EquipamentoService;
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
@RequestMapping("rpg_manager/equipamento")
public class EquipamentoController {
    private EquipamentoService equipamentoService;

    @GetMapping
    public ResponseEntity<List<Equipamento>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!equipamentoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o equipamento!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EquipamentoDTO equipamentoDTO){
        Equipamento equipamento = new Equipamento();
        BeanUtils.copyProperties(equipamentoDTO, equipamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamentoService.save(equipamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid EquipamentoDTO equipamentoDTO){
        if (!equipamentoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este equipamento não existe.");
        }

        Equipamento equipamento = new Equipamento();
        BeanUtils.copyProperties(equipamentoDTO, equipamento);
        equipamento.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.save(equipamento));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!equipamentoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o equipamento!");
        }

        equipamentoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Equipamento deletado com sucesso!");
    }
}

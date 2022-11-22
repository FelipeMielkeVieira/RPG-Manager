package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.CampanhaDTO;
import br.senai.sc.rpgGenerator.model.entities.Campanha;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.model.service.CampanhaService;
import br.senai.sc.rpgGenerator.util.CampanhaUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("rpg_manager/campanha")
public class CampanhaController {
    private CampanhaService campanhaService;

    @GetMapping
    public ResponseEntity<List<Campanha>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(campanhaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!campanhaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a campanha!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(campanhaService.findById(id).get());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Campanha>> findPage(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam Usuario usuario, @RequestParam(required = false) String nome) {
        if(nome != null && !nome.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(campanhaService.findPage(usuario, nome, pageable));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(campanhaService.findPage(usuario, pageable));
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestParam("mapa") String campanhaJson,
                                       @RequestParam("mapa") MultipartFile[] mapas){
        CampanhaUtil campanhaUtil = new CampanhaUtil();
        Campanha campanha = campanhaUtil.convertJsonToModel(campanhaJson);
        campanha.setMapa(mapas);

        return ResponseEntity.status(HttpStatus.CREATED).body(campanhaService.save(campanha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid CampanhaDTO campanhaDTO){
        if (!campanhaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta campanha não existe.");
        }

        Campanha campanha = new Campanha();
        BeanUtils.copyProperties(campanhaDTO, campanha);
        campanha.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(campanhaService.save(campanha));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!campanhaService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a campanha!");
        }

        campanhaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Campanha deletada com sucesso!");
    }
}

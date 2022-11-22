package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.PersonagemDTO;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.model.service.PersonagemService;
import br.senai.sc.rpgGenerator.util.PersonagemUtil;
import lombok.*;
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
@RequestMapping("rpg_manager/personagem")
public class PersonagemController {
    private PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<List<Personagem>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(personagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        if (!personagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o personagem!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(personagemService.findById(id).get());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Personagem>> findPage(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                                     @RequestParam Usuario usuario, @RequestParam(required = false) String nome) {
        if(nome != null && !nome.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(personagemService.findPage(usuario, nome, pageable));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(personagemService.findPage(usuario, pageable));
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestParam("personagem") String personagemJson, @RequestParam("arquivos") List<MultipartFile> arquivos){
        PersonagemUtil personagemUtil = new PersonagemUtil();
        Personagem personagem = personagemUtil.convertJsonToModel(personagemJson);
        personagem.setArquivos(arquivos);
        return ResponseEntity.status(HttpStatus.CREATED).body(personagemService.save(personagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid PersonagemDTO personagemDTO){
        if (!personagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este personagem não existe.");
        }

        Personagem personagem = new Personagem();
        BeanUtils.copyProperties(personagemDTO, personagem);
        personagem.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(personagemService.save(personagem));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if(!personagemService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o personagem!");
        }

        personagemService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Personagem deletado com sucesso!");
    }
}

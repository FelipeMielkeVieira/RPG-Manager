package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.dto.UsuarioDTO;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.model.service.UsuarioService;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@AllArgsConstructor
@RequestMapping("rpg_manager/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> findById(@PathVariable(value = "email") String email){
        if (!usuarioService.existsById(email)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o usuário!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(email).get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        usuario.setSenha(encoder.encode(usuario.getSenha()));

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }

    @PutMapping("/{email}")
    public ResponseEntity<Object> update(@PathVariable(value = "email") String email, @RequestBody @Valid UsuarioDTO usuarioDTO){
        if (!usuarioService.existsById(email)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este usuário não existe.");
        }
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }

    @Transactional
    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "email") String email){
        if(!usuarioService.existsById(email)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o usuário!");
        }

        usuarioService.deleteById(email);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }
}

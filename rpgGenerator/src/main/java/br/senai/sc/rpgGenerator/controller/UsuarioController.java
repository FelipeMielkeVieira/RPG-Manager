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
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        usuario.setSenha(encoder.encode(usuario.getSenha()));

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<Object> login(@PathVariable(value = "email") String email, @PathVariable(value = "senha") String senha) {
        Optional<Usuario> usuario = usuarioService.findByEmailAndSenha(email, senha);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login não existente!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }

    @Transactional
    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "email") String email){
        usuarioService.deleteById(email);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }
}

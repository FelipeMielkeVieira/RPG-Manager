package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.model.entities.Mapa;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.model.service.MapaService;
import br.senai.sc.rpgGenerator.model.service.UsuarioService;
import br.senai.sc.rpgGenerator.util.MapaUtil;
import br.senai.sc.rpgGenerator.util.UsuarioUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@AllArgsConstructor
@RequestMapping("rpg_manager/mapa")
public class MapaController {
    private MapaService mapaService;
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Mapa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Mapa>> findByUser(@PathVariable(value = "id") Long idUsuario) {
        Usuario usuario = usuarioService.findById(idUsuario);

        return ResponseEntity.status(HttpStatus.OK).body(mapaService.findByUsuario(usuario));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestParam("usuario") Long idUsuario,
                                       @RequestParam("nome") String nome,
                                       @RequestParam("mapa") MultipartFile file) {
        Mapa mapa = new Mapa();
        Usuario usuario = usuarioService.findById(idUsuario);
        System.out.println(usuario.toString());

        mapa.setNome(nome);
        mapa.setUsuario(usuario);
        mapa.setArquivo(file);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapaService.save(mapa));
    }
}

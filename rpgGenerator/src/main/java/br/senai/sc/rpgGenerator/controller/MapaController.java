package br.senai.sc.rpgGenerator.controller;

import br.senai.sc.rpgGenerator.model.entities.Mapa;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.model.service.MapaService;
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

    @GetMapping
    public ResponseEntity<List<Mapa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestParam("usuario") String usuarioJson,
                                       @RequestParam("nome") String nome,
                                       @RequestParam("mapa") MultipartFile file) {
        UsuarioUtil usuarioUtil = new UsuarioUtil();
        Usuario usuario = usuarioUtil.convertJsonToModel(usuarioJson);

        Mapa mapa = new Mapa();

        mapa.setNome(nome);
        mapa.setUsuario(usuario);
        mapa.setArquivo(file);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapaService.save(mapa));
    }
}

package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Mapa;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapaRepository extends JpaRepository<Mapa, Long> {
    List<Mapa> findByUsuario(Usuario usuario);
}

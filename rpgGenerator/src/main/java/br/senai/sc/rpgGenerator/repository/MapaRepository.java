package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Mapa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapaRepository extends JpaRepository<Mapa, Long> {
}

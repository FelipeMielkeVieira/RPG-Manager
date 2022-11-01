package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Aliado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AliadoRepository extends JpaRepository<Aliado, Long> {
}

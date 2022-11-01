package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.ExtrasPersonagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtrasPersonagemRepository extends JpaRepository<ExtrasPersonagem, Long> {
}

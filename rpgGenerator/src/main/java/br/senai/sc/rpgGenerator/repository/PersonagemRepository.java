package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}

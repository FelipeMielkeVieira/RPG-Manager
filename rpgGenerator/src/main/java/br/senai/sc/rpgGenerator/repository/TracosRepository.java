package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Tracos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TracosRepository extends JpaRepository<Tracos, Long> {
}

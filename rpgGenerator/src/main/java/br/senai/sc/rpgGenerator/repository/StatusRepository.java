package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}

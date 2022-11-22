package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    Page<Personagem> findByUsuarioAndNomeContaining(Usuario usuario, String nome, Pageable pageable);

    Page<Personagem> findByUsuario(Usuario usuario, Pageable pageable);
}

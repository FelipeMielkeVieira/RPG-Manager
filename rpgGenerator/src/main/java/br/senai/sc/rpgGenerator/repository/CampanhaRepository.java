package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Campanha;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

    Page<Campanha> findByUsuarioAndNomeContaining(Usuario usuario, String nome, Pageable pageable);

    Page<Campanha> findByUsuario(Usuario usuario, Pageable pageable);

    List<Campanha> findByUsuarioAndArquivada(Usuario usuario, Boolean arquivada);
}

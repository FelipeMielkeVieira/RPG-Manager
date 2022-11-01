package br.senai.sc.rpgGenerator.repository;

import br.senai.sc.rpgGenerator.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}

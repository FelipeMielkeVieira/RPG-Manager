package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.repository.UsuarioRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public <S extends Usuario> S save(S entity) {
        return usuarioRepository.save(entity);
    }

    public Optional<Usuario> findById(String email) {
        return usuarioRepository.findById(email);
    }

    public boolean existsById(String email) {
        return usuarioRepository.existsById(email);
    }

    public void deleteById(String email) {
        usuarioRepository.deleteById(email);
    }
}

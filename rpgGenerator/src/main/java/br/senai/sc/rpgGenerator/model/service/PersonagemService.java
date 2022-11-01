package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Personagem;
import br.senai.sc.rpgGenerator.repository.PersonagemRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {
    private PersonagemRepository personagemRepository;

    public List<Personagem> findAll() {
        return personagemRepository.findAll();
    }

    public <S extends Personagem> S save(S entity) {
        return personagemRepository.save(entity);
    }

    public Optional<Personagem> findById(Long id) {
        return personagemRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return personagemRepository.existsById(id);
    }

    public void deleteById(Long id) {
        personagemRepository.deleteById(id);
    }
}

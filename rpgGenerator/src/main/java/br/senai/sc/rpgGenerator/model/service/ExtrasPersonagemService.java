package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.ExtrasPersonagem;
import br.senai.sc.rpgGenerator.repository.ExtrasPersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtrasPersonagemService {
    private ExtrasPersonagemRepository extrasPersonagemRepository;

    public List<ExtrasPersonagem> findAll() {
        return extrasPersonagemRepository.findAll();
    }

    public <S extends ExtrasPersonagem> S save(S entity) {
        return extrasPersonagemRepository.save(entity);
    }

    public Optional<ExtrasPersonagem> findById(Long aLong) {
        return extrasPersonagemRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return extrasPersonagemRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        extrasPersonagemRepository.deleteById(aLong);
    }
}

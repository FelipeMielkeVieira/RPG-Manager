package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Ataque;
import br.senai.sc.rpgGenerator.repository.AtaqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AtaqueService {
    private AtaqueRepository ataqueRepository;

    public List<Ataque> findAll() {
        return ataqueRepository.findAll();
    }

    public <S extends Ataque> S save(S entity) {
        return ataqueRepository.save(entity);
    }

    public Optional<Ataque> findById(Long aLong) {
        return ataqueRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return ataqueRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        ataqueRepository.deleteById(aLong);
    }
}

package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Pericias;
import br.senai.sc.rpgGenerator.repository.PericiasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PericiasService {
    private PericiasRepository periciasRepository;

    public List<Pericias> findAll() {
        return periciasRepository.findAll();
    }

    public <S extends Pericias> S save(S entity) {
        return periciasRepository.save(entity);
    }

    public Optional<Pericias> findById(Long aLong) {
        return periciasRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return periciasRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        periciasRepository.deleteById(aLong);
    }
}

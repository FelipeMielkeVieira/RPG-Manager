package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Campanha;
import br.senai.sc.rpgGenerator.repository.CampanhaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CampanhaService {
    private CampanhaRepository campanhaRepository;

    public List<Campanha> findAll() {
        return campanhaRepository.findAll();
    }

    public <S extends Campanha> S save(S entity) {
        return campanhaRepository.save(entity);
    }

    public Optional<Campanha> findById(Long aLong) {
        return campanhaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return campanhaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        campanhaRepository.deleteById(aLong);
    }
}

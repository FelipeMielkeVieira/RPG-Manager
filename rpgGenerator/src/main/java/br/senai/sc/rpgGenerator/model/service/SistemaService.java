package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Sistema;
import br.senai.sc.rpgGenerator.repository.SistemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SistemaService {
    private SistemaRepository sistemaRepository;

    public List<Sistema> findAll() {
        return sistemaRepository.findAll();
    }

    public <S extends Sistema> S save(S entity) {
        return sistemaRepository.save(entity);
    }

    public Optional<Sistema> findById(Long aLong) {
        return sistemaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return sistemaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        sistemaRepository.deleteById(aLong);
    }
}

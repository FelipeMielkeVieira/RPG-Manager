package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Salvaguarda;
import br.senai.sc.rpgGenerator.repository.SalvaguardaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalvaguardaService {
    private SalvaguardaRepository salvaguardaRepository;

    public List<Salvaguarda> findAll() {
        return salvaguardaRepository.findAll();
    }

    public <S extends Salvaguarda> S save(S entity) {
        return salvaguardaRepository.save(entity);
    }

    public Optional<Salvaguarda> findById(Long aLong) {
        return salvaguardaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return salvaguardaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        salvaguardaRepository.deleteById(aLong);
    }
}

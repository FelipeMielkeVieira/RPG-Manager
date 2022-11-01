package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Vinculo;
import br.senai.sc.rpgGenerator.repository.VinculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VinculoService {
    private VinculoRepository vinculoRepository;

    public List<Vinculo> findAll() {
        return vinculoRepository.findAll();
    }

    public <S extends Vinculo> S save(S entity) {
        return vinculoRepository.save(entity);
    }

    public Optional<Vinculo> findById(Long aLong) {
        return vinculoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return vinculoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        vinculoRepository.deleteById(aLong);
    }
}

package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Aliado;
import br.senai.sc.rpgGenerator.repository.AliadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AliadoService {
    private AliadoRepository aliadoRepository;

    public List<Aliado> findAll() {
        return aliadoRepository.findAll();
    }

    public <S extends Aliado> S save(S entity) {
        return aliadoRepository.save(entity);
    }

    public Optional<Aliado> findById(Long id) {
        return aliadoRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return aliadoRepository.existsById(id);
    }

    public void deleteById(Long aLong) {
        aliadoRepository.deleteById(aLong);
    }
}

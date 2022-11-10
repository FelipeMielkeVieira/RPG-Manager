package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Equipamento;
import br.senai.sc.rpgGenerator.repository.EquipamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EquipamentoService {
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> findAll() {
        return equipamentoRepository.findAll();
    }

    public <S extends Equipamento> S save(S entity) {
        return equipamentoRepository.save(entity);
    }

    public Optional<Equipamento> findById(Long aLong) {
        return equipamentoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return equipamentoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        equipamentoRepository.deleteById(aLong);
    }
}

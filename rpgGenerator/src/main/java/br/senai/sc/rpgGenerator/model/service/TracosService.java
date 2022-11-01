package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Tracos;
import br.senai.sc.rpgGenerator.repository.TracosRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Service
public class TracosService {
    private TracosRepository tracosRepository;

    public List<Tracos> findAll() {
        return tracosRepository.findAll();
    }

    public <S extends Tracos> S save(S entity) {
        return tracosRepository.save(entity);
    }

    public Optional<Tracos> findById(Long id) {
        return tracosRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return tracosRepository.existsById(id);
    }

    public void deleteById(Long id) {
        tracosRepository.deleteById(id);
    }
}

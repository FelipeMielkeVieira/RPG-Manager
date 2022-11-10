package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Status;
import br.senai.sc.rpgGenerator.repository.StatusRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusService {
    private StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public <S extends Status> S save(S entity) {
        return statusRepository.save(entity);
    }

    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return statusRepository.existsById(id);
    }

    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }
}

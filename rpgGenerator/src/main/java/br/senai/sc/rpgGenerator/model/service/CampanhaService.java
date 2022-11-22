package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Campanha;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.repository.CampanhaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Campanha> findPage(Usuario usuario, String nome, Pageable pageable) {
        return campanhaRepository.findByUsuarioAndNomeContaining(usuario, nome, pageable);
    }

    public Page<Campanha> findPage(Usuario usuario, Pageable pageable) {
        return campanhaRepository.findByUsuario(usuario, pageable);
    }
}

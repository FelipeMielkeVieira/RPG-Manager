package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Imagem;
import br.senai.sc.rpgGenerator.repository.ImagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImagemService {
    private ImagemRepository imagemRepository;

    public List<Imagem> findAll() {
        return imagemRepository.findAll();
    }

    public <S extends Imagem> S save(S entity) {
        return imagemRepository.save(entity);
    }

    public Optional<Imagem> findById(Long aLong) {
        return imagemRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return imagemRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        imagemRepository.deleteById(aLong);
    }
}

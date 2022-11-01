package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Organizacao;
import br.senai.sc.rpgGenerator.repository.OrganizacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizacaoService {
    private OrganizacaoRepository organizacaoRepository;

    public List<Organizacao> findAll() {
        return organizacaoRepository.findAll();
    }

    public <S extends Organizacao> S save(S entity) {
        return organizacaoRepository.save(entity);
    }

    public Optional<Organizacao> findById(Long aLong) {
        return organizacaoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return organizacaoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        organizacaoRepository.deleteById(aLong);
    }
}

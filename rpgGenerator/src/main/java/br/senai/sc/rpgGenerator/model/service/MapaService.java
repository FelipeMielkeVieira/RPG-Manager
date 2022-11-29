package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.model.entities.Mapa;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import br.senai.sc.rpgGenerator.repository.MapaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MapaService {
    private MapaRepository mapaRepository;

    public List<Mapa> findAll() {
        return mapaRepository.findAll();
    }

    public <S extends Mapa> S save(S entity) {
        return mapaRepository.save(entity);
    }

    public Optional<Mapa> findById(Long aLong) {
        return mapaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return mapaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        mapaRepository.deleteById(aLong);
    }

    public List<Mapa> findByUsuario(Usuario usuario) {
        return mapaRepository.findByUsuario(usuario);
    }
}

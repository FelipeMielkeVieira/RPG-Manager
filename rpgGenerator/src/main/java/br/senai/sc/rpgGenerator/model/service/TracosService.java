package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.repository.TracosRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;

@Service
public class TracosService {
    private TracosRepository tracosRepository;
}

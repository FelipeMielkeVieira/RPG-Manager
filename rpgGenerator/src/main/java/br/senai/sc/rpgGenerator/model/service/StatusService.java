package br.senai.sc.rpgGenerator.model.service;

import br.senai.sc.rpgGenerator.repository.StatusRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;

@Service
public class StatusService {
    private StatusRepository statusRepository;
}

package br.senai.sc.rpgGenerator.util;

import br.senai.sc.rpgGenerator.dto.PersonagemDTO;
import br.senai.sc.rpgGenerator.model.entities.Personagem;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

public class PersonagemUtil {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Personagem convertJsonToModel(String personagemJson) {
        PersonagemDTO personagemDTO = convertJsonToDto(personagemJson);
        return convertoDtoToModel(personagemDTO);
    }

    public PersonagemDTO convertJsonToDto(String personagemJson) {
        try {
            return this.objectMapper.readValue(personagemJson, PersonagemDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Personagem convertoDtoToModel(@Valid PersonagemDTO personagemDTO) {
        return this.objectMapper.convertValue(personagemDTO, Personagem.class);
    }
}

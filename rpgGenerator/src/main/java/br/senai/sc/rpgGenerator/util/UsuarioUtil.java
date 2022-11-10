package br.senai.sc.rpgGenerator.util;

import br.senai.sc.rpgGenerator.dto.UsuarioDTO;
import br.senai.sc.rpgGenerator.model.entities.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

public class UsuarioUtil {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Usuario convertJsonToModel(String usuarioJson) {
        UsuarioDTO usuarioDTO = convertJsonToDto(usuarioJson);
        return convertoDtoToModel(usuarioDTO);
    }

    public UsuarioDTO convertJsonToDto(String usuarioJson) {
        try {
            return this.objectMapper.readValue(usuarioJson, UsuarioDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario convertoDtoToModel(@Valid UsuarioDTO usuarioDTO) {
        return this.objectMapper.convertValue(usuarioDTO, Usuario.class);
    }
}

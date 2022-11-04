package br.senai.sc.rpgGenerator.util;

import br.senai.sc.rpgGenerator.dto.ImagemDTO;
import br.senai.sc.rpgGenerator.model.entities.Imagem;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.Valid;

public class ImagemUtil {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Imagem convertJsonToModel(String imagemJson) {
        ImagemDTO imagemDTO = convertJsonToDto(imagemJson);
        return convertoDtoToModel(imagemDTO);
    }

    public ImagemDTO convertJsonToDto(String imagemJson) {
        try {
            return this.objectMapper.readValue(imagemJson, ImagemDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Imagem convertoDtoToModel(@Valid ImagemDTO imagemDTO) {
        return this.objectMapper.convertValue(imagemDTO, Imagem.class);
    }
}

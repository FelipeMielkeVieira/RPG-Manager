package br.senai.sc.rpgGenerator.util;

import br.senai.sc.rpgGenerator.dto.MapaDTO;
import br.senai.sc.rpgGenerator.model.entities.Mapa;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.Valid;

public class MapaUtil {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Mapa convertJsonToModel(String mapaJson) {
        MapaDTO mapaDTO = convertJsonToDto(mapaJson);
        return convertoDtoToModel(mapaDTO);
    }

    public MapaDTO convertJsonToDto(String mapaJson) {
        try {
            return this.objectMapper.readValue(mapaJson, MapaDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Mapa convertoDtoToModel(@Valid MapaDTO mapaDTO) {
        return this.objectMapper.convertValue(mapaDTO, Mapa.class);
    }
}

package br.senai.sc.rpgGenerator.util;

import br.senai.sc.rpgGenerator.dto.CampanhaDTO;
import br.senai.sc.rpgGenerator.dto.CampanhaFullDTO;
import br.senai.sc.rpgGenerator.model.entities.Campanha;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

public class CampanhaUtil {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Campanha convertJsonToModel(String campanhaJson) {
        CampanhaDTO campanhaDTO = convertJsonToDto(campanhaJson);
        return convertoDtoToModel(campanhaDTO);
    }

    public Campanha convertJsonToFullModel(String campanhaJson) {
        CampanhaFullDTO CampanhaFullDTO = convertJsonToFullDto(campanhaJson);
        return convertoFullDtoToModel(CampanhaFullDTO);
    }

    public CampanhaDTO convertJsonToDto(String campanhaJson) {
        try {
            return this.objectMapper.readValue(campanhaJson, CampanhaDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CampanhaFullDTO convertJsonToFullDto(String campanhaJson) {
        try {
            return this.objectMapper.readValue(campanhaJson, CampanhaFullDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Campanha convertoDtoToModel(@Valid CampanhaDTO campanhaDTO) {
        return this.objectMapper.convertValue(campanhaDTO, Campanha.class);
    }

    public Campanha convertoFullDtoToModel(@Valid CampanhaFullDTO campanhaFullDTO) {
        return this.objectMapper.convertValue(campanhaFullDTO, Campanha.class);
    }
}

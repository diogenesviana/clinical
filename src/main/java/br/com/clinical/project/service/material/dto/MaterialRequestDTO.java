package br.com.clinical.project.service.material.dto;

import br.com.clinical.project.model.material.Material;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class MaterialRequestDTO {

    private Long idMaterial;
    private Long txMaterial;
    private BigDecimal qtMaterial;


    public MaterialRequestDTO toDto(ModelMapper modelMapper, Material material){
        return modelMapper.map(material, MaterialRequestDTO.class);
    }

}

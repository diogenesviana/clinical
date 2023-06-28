package br.com.clinical.project.service.material.dto;

import br.com.clinical.project.model.material.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialRequestDTO {

    private Long idMaterial;
    private String txMaterial;
    private BigDecimal qtMaterial;


    public static MaterialRequestDTO toDto(ModelMapper modelMapper, Material material){
        return modelMapper.map(material, MaterialRequestDTO.class);
    }

    public static List<MaterialRequestDTO> listToDTO(ModelMapper modelMapper, List<Material> materials) {
        return materials.stream()
                .map(material -> toDto(modelMapper, material))
                .toList();
    }

    public Material toEntity(ModelMapper modelMapper, MaterialRequestDTO materialRequestDTO){
        return modelMapper.map(materialRequestDTO, Material.class);
    }

}

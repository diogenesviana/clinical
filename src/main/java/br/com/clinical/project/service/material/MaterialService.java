package br.com.clinical.project.service.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.repository.material.MaterialRepository;
import br.com.clinical.project.service.material.dto.MaterialRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    ModelMapper modelMapper;

    public MaterialRequestDTO findById(Long materialId){
        Optional<Material> materialOptional = materialRepository.findById(materialId);
        MaterialRequestDTO materialRequestDTO = new MaterialRequestDTO();
        if(materialOptional.isPresent()){
            Material material = materialOptional.get();
            return materialRequestDTO.toDto(modelMapper, material);
        }
        return null;
    }
}

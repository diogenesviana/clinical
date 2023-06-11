package br.com.clinical.project.service.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.repository.material.MaterialRepository;
import br.com.clinical.project.service.material.dto.MaterialRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    ModelMapper modelMapper;

    public MaterialRequestDTO findById(Long idMaterial){
        Optional<Material> materialOptional = materialRepository.findById(idMaterial);
        MaterialRequestDTO materialRequestDTO = new MaterialRequestDTO();
        if(materialOptional.isPresent()){
            Material material = materialOptional.get();
            return materialRequestDTO.toDto(modelMapper, material);
        }
        return null;
    }

    public List<MaterialRequestDTO> findAll(){
        List<MaterialRequestDTO> dtoList = new ArrayList<>();
        MaterialRequestDTO dto = new MaterialRequestDTO();
        List<Material> all = materialRepository.findAll();
        for(Material material : all){
            dtoList.add(dto.toDto(modelMapper, material));
        }
       return dtoList;
    }

    public void create(MaterialRequestDTO materialRequestDTO){
        materialRepository.save(materialRequestDTO.toEntity(modelMapper, materialRequestDTO));
    }

    public MaterialRequestDTO update(Long idMaterial, MaterialRequestDTO materialRequestDTO){
        Optional<Material> materialOptional = materialRepository.findById(idMaterial);
        if(materialOptional.isPresent()){
            Material material = materialOptional.get();
            materialRequestDTO.setIdMaterial(material.getIdMaterial());
            materialRepository.save(materialRequestDTO.toEntity(modelMapper, materialRequestDTO));
            return materialRequestDTO;
        }
        throw new RuntimeException("Não encontrado!");
    }
}

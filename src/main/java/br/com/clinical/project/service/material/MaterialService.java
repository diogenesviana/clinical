package br.com.clinical.project.service.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.repository.material.MaterialRepository;
import br.com.clinical.project.service.exception.ObjectNotFoundException;
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

    public Material findById(Long idMaterial){
        Optional<Material> material = materialRepository.findById(idMaterial);
            return material.orElseThrow(() -> new ObjectNotFoundException("Material não encontrado"));
    }

    public List<Material> findAll(){
        return materialRepository.findAll();
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
        } else {
            throw new ObjectNotFoundException("Material não encontrado");
        }
    }
}

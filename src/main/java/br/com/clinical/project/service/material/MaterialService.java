package br.com.clinical.project.service.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.repository.material.MaterialRepository;
import br.com.clinical.project.service.exception.BusinessException;
import br.com.clinical.project.service.exception.ObjectNotFoundException;
import br.com.clinical.project.service.material.dto.MaterialRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    public static final String MATERIAL_NOT_FOUND = "Material não encontrado";
    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    ModelMapper modelMapper;

    public Material findById(Long idMaterial){
        Optional<Material> material = materialRepository.findById(idMaterial);
            return material.orElseThrow(() -> new ObjectNotFoundException(MATERIAL_NOT_FOUND));
    }
    public Optional<Material> findByTxMaterial(String txMaterial){
        return materialRepository.findByTxMaterial(txMaterial);
    }

    public List<Material> findAll(){
        return materialRepository.findAll();
    }

    public Material create(MaterialRequestDTO materialRequestDTO) {
        Optional<Material> materialOptional = findByTxMaterial(materialRequestDTO.getTxMaterial());
        if (materialOptional.isEmpty()) {
            return materialRepository.save(materialRequestDTO.toEntity(modelMapper, materialRequestDTO));
        } else {
            throw new BusinessException(materialOptional.get().getTxMaterial() + " já existe no sistema");
        }

    }

    public Material update(Long idMaterial, MaterialRequestDTO materialRequestDTO){
        Material material = findById(idMaterial);
        materialRequestDTO.setIdMaterial(material.getIdMaterial());
        material = materialRequestDTO.toEntity(modelMapper, materialRequestDTO);
        return materialRepository.save(material);
    }
}

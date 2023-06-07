package br.com.clinical.project.service;

import br.com.clinical.project.model.Material;
import br.com.clinical.project.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public Optional<Material> findById(Long materialId){
        return materialRepository.findById(materialId);
    }
}

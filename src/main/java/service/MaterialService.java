package service;

import model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MaterialRepository;

import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public Optional<Material> findById(Long materialId){
        return materialRepository.findById(materialId);
    }
}

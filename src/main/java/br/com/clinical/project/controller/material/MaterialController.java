package br.com.clinical.project.controller.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.service.material.dto.MaterialRequestDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.clinical.project.service.material.MaterialService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{idMaterial}")
    public ResponseEntity<MaterialRequestDTO> findById (@PathVariable Long idMaterial){
        Material material = materialService.findById(idMaterial);
        return ResponseEntity.ok(MaterialRequestDTO.toDto(modelMapper, material));
    }

    @GetMapping
    public ResponseEntity<List<MaterialRequestDTO>> findAll(){
        List<Material> materials = materialService.findAll();
        return ResponseEntity.ok(MaterialRequestDTO.listToDTO(modelMapper, materials));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create (@RequestBody MaterialRequestDTO materialRequestDTO){
        materialService.create(materialRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idMaterial}")
    public ResponseEntity<MaterialRequestDTO> update(@PathVariable Long idMaterial, @RequestBody MaterialRequestDTO materialRequestDTO){
        return ResponseEntity.ok(materialService.update(idMaterial, materialRequestDTO));
    }

}

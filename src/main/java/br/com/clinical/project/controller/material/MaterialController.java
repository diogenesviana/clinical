package br.com.clinical.project.controller.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.service.material.dto.MaterialRequestDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.clinical.project.service.material.MaterialService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<MaterialRequestDTO> create (@RequestBody MaterialRequestDTO materialRequestDTO){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idMaterial}")
                .buildAndExpand(MaterialRequestDTO.toDto(modelMapper, materialService.create(materialRequestDTO)))
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{idMaterial}")
    public ResponseEntity<MaterialRequestDTO> update(@PathVariable Long idMaterial, @RequestBody MaterialRequestDTO materialRequestDTO){
        Material material = materialService.update(idMaterial, materialRequestDTO);
        return ResponseEntity.ok(MaterialRequestDTO.toDto(modelMapper, material));
    }

}

package br.com.clinical.project.controller.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.service.material.dto.MaterialRequestDTO;
import lombok.AllArgsConstructor;
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

    @GetMapping("/{idMaterial}")
    public ResponseEntity<MaterialRequestDTO> findById (@PathVariable Long idMaterial){
        MaterialRequestDTO dto = materialService.findById(idMaterial);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<MaterialRequestDTO>> findAll(){
        List<MaterialRequestDTO> dtoList = materialService.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create (@RequestBody MaterialRequestDTO materialRequestDTO){
        materialService.create(materialRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idMaterial}")
    public ResponseEntity<MaterialRequestDTO> update(@PathVariable Long idMaterial, @RequestBody MaterialRequestDTO materialRequestDTO){
        MaterialRequestDTO dto = materialService.update(idMaterial, materialRequestDTO);
        return ResponseEntity.ok(dto);
    }

}

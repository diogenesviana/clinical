package br.com.clinical.project.controller.material;

import br.com.clinical.project.model.material.Material;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.clinical.project.service.material.MaterialService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @GetMapping("/{materialId}")
    public ResponseEntity<Optional<Material>> findById (@PathVariable Long materialId){
        Optional<Material> byId = materialService.findById(materialId);
        return ResponseEntity.ok(byId);
    }

}

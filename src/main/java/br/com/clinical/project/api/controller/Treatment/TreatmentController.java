package br.com.clinical.project.api.controller.Treatment;

import br.com.clinical.project.domain.service.treatment.TreatmentService;
import br.com.clinical.project.api.model.treatment.TreatmentResquestDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/treatment")
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/{idTreatment}")
    public ResponseEntity<TreatmentResquestDTO> findbyId (@PathVariable Long idTreatment){
        TreatmentResquestDTO dto = treatmentService.findById(idTreatment);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping
    public ResponseEntity<List<TreatmentResquestDTO>> findAll(){
        List<TreatmentResquestDTO> dtoList = treatmentService.findAll();
        return ResponseEntity.ok(dtoList);
    }


}

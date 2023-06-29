package br.com.clinical.project.api.controller.Treatment;

import br.com.clinical.project.domain.model.treatment.Treatment;
import br.com.clinical.project.domain.service.treatment.TreatmentService;
import br.com.clinical.project.api.model.treatment.TreatmentRequestDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{idTreatment}")
    public ResponseEntity<TreatmentRequestDTO> findById (@PathVariable Long idTreatment){
        Treatment treatment = treatmentService.findById(idTreatment);
        return ResponseEntity.ok(TreatmentRequestDTO.toDto(modelMapper, treatment));
    }
    
    @GetMapping
    public ResponseEntity<List<TreatmentRequestDTO>> findAll(){
        List<Treatment> treatments = treatmentService.findAll();
        return ResponseEntity.ok(TreatmentRequestDTO.listToDTO(modelMapper, treatments));
    }


}

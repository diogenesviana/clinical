package br.com.clinical.project.service.treatment.dto;

import br.com.clinical.project.model.treatment.Treatment;
import br.com.clinical.project.repository.treatment.TreatmentRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class TreatmentResquestDTO {

    private Long idTreatment;
    private String txTreatment;
    private String txDescription;


    public TreatmentResquestDTO toDto(ModelMapper modelMapper, Treatment treatment){
        return modelMapper.map(treatment, TreatmentResquestDTO.class);
    }

    public List<TreatmentResquestDTO> listToDTO (ModelMapper modelMapper, List<Treatment> treatments){
        return treatments.stream()
                .map(treatment -> toDto(modelMapper, treatment))
                .toList();
    }

    public Treatment toEntity(ModelMapper modelMapper, TreatmentResquestDTO treatmentResquestDTO){
        return modelMapper.map(treatmentResquestDTO, Treatment.class);
    }

}

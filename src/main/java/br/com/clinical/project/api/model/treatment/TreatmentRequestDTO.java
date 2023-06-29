package br.com.clinical.project.api.model.treatment;

import br.com.clinical.project.domain.model.treatment.Treatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentRequestDTO {

    private Long idTreatment;
    private String txTreatment;
    private String txDescription;


    public TreatmentRequestDTO toDto(ModelMapper modelMapper, Treatment treatment){
        return modelMapper.map(treatment, TreatmentRequestDTO.class);
    }

    public List<TreatmentRequestDTO> listToDTO (ModelMapper modelMapper, List<Treatment> treatments){
        return treatments.stream()
                .map(treatment -> toDto(modelMapper, treatment))
                .toList();
    }

    public Treatment toEntity(ModelMapper modelMapper, TreatmentRequestDTO treatmentResquestDTO){
        return modelMapper.map(treatmentResquestDTO, Treatment.class);
    }

}

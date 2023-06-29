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


    public static TreatmentRequestDTO toDto(ModelMapper modelMapper, Treatment treatment){
        return modelMapper.map(treatment, TreatmentRequestDTO.class);
    }

    public static List<TreatmentRequestDTO> listToDTO (ModelMapper modelMapper, List<Treatment> treatments){
        return treatments.stream()
                .map(treatment -> toDto(modelMapper, treatment))
                .toList();
    }

    public Treatment toEntity(ModelMapper modelMapper, TreatmentRequestDTO treatmentRequestDTO){
        return modelMapper.map(treatmentRequestDTO, Treatment.class);
    }

}

package br.com.clinical.project.domain.service.treatment;

import br.com.clinical.project.domain.model.treatment.Treatment;
import br.com.clinical.project.api.model.treatment.TreatmentRequestDTO;
import br.com.clinical.project.domain.repository.treatment.TreatmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    ModelMapper modelMapper;

    public TreatmentRequestDTO findById(Long idTreatment){
        Optional<Treatment> treatmentOptional = treatmentRepository.findById(idTreatment);
        TreatmentRequestDTO treatmentResquestDTO = new TreatmentRequestDTO();
        if(treatmentOptional.isPresent()){
            Treatment treatment = treatmentOptional.get();
            return treatmentResquestDTO.toDto(modelMapper, treatment);
        }
        return null;
    }

    public List<TreatmentRequestDTO> findAll(){
        List<TreatmentRequestDTO>  dtoList = new ArrayList<>();
        TreatmentRequestDTO dto = new TreatmentRequestDTO();
        List<Treatment> all = treatmentRepository.findAll();
        for(Treatment treatment : all){
            dtoList.add(dto.toDto(modelMapper, treatment));
        }
        return dtoList;
    }

}

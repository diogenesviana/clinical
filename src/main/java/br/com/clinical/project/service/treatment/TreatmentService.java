package br.com.clinical.project.service.treatment;

import br.com.clinical.project.model.treatment.Treatment;
import br.com.clinical.project.repository.treatment.TreatmentRepository;
import br.com.clinical.project.service.treatment.dto.TreatmentResquestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    ModelMapper modelMapper;

    public TreatmentResquestDTO findById(Long idTreatment){
        Optional<Treatment> treatmentOptional = treatmentRepository.findById(idTreatment);
        TreatmentResquestDTO treatmentResquestDTO = new TreatmentResquestDTO();
        if(treatmentOptional.isPresent()){
            Treatment treatment = treatmentOptional.get();
            return treatmentResquestDTO.toDto(modelMapper, treatment);
        }
        return null;
    }

    public List<TreatmentResquestDTO> findAll(){
        List<TreatmentResquestDTO>  dtoList = new ArrayList<>();
        TreatmentResquestDTO dto = new TreatmentResquestDTO();
        List<Treatment> all = treatmentRepository.findAll();
        for(Treatment treatment : all){
            dtoList.add(dto.toDto(modelMapper, treatment));
        }
        return dtoList;
    }

}

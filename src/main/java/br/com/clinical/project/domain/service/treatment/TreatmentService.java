package br.com.clinical.project.domain.service.treatment;

import br.com.clinical.project.domain.exception.BusinessException;
import br.com.clinical.project.domain.model.treatment.Treatment;
import br.com.clinical.project.domain.repository.treatment.TreatmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {

    public static final String TREATMENT_NOT_FOUND = "Tratamento não encontrado";

    @Autowired
    TreatmentRepository treatmentRepository;
    @Autowired
    ModelMapper modelMapper;


    public Treatment findById(Long idTreatment){
        Optional<Treatment> treatment = treatmentRepository.findById(idTreatment);
        return treatment.orElseThrow(() -> new BusinessException(TREATMENT_NOT_FOUND));
    }
    public List<Treatment> findAll(){
        return treatmentRepository.findAll();
    }

}

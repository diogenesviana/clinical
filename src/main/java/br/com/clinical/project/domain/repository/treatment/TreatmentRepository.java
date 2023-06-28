package br.com.clinical.project.domain.repository.treatment;

import br.com.clinical.project.domain.model.treatment.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository <Treatment, Long> {
}

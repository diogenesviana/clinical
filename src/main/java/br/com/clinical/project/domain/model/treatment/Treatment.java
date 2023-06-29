package br.com.clinical.project.domain.model.treatment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "treatment")
public class Treatment {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column (name = "id_treatment")
        private Long idTreatment;

        @Column (name = "tx_treatment")
        private String txTreatment;

        @Column (name = "tx_description")
        private String txDescription;


}

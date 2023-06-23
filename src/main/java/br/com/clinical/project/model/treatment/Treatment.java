package br.com.clinical.project.model.treatment;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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

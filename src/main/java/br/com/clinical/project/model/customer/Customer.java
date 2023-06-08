package br.com.clinical.project.model.customer;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "tx_customer")
    private String txCustomer;

    @Column(name = "tx_phone")
    private String txPhone;

    @Column(name = "tx_email")
    private String txEmail;

    @Column(name = "dt_birth")
    private LocalDate dtBirth;

    @Column(name = "tx_observations")
    private String txObservations;


}

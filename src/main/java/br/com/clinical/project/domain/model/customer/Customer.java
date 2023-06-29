package br.com.clinical.project.domain.model.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
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

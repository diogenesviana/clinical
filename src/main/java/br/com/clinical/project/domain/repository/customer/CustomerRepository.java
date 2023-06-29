package br.com.clinical.project.domain.repository.customer;


import br.com.clinical.project.domain.model.customer.Customer;
import br.com.clinical.project.domain.model.material.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByTxEmail(String txEmail);
}

package br.com.clinical.project.repository.customer;


import br.com.clinical.project.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

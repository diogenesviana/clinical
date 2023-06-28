package br.com.clinical.project.domain.service.customer;

import br.com.clinical.project.domain.model.customer.Customer;
import br.com.clinical.project.domain.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}

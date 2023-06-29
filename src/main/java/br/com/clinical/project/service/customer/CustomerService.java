package br.com.clinical.project.service.customer;

import br.com.clinical.project.model.customer.Customer;
import br.com.clinical.project.repository.customer.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}

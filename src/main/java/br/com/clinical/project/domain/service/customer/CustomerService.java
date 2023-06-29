package br.com.clinical.project.domain.service.customer;

import br.com.clinical.project.domain.exception.BusinessException;
import br.com.clinical.project.api.exceptionhandler.ObjectNotFoundException;
import br.com.clinical.project.api.model.customer.CustomerRequestDTO;
import br.com.clinical.project.domain.model.customer.Customer;
import br.com.clinical.project.domain.repository.customer.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    public static final String CUSTOMER_NOT_FOUND = "Cliente não encontrado";
    public static final String EXISTS = " já existe no sistema";

    public static final String EMAIL_EXISTS = "Email já foi utilizado";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    public Customer findById(Long idCustomer){
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        return customer.orElseThrow(() -> new ObjectNotFoundException(CUSTOMER_NOT_FOUND));
    }
    public Optional<Customer> findByTxEmail(String txEmail){
        return customerRepository.findByTxEmail(txEmail);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer create(CustomerRequestDTO customerRequestDTO) {
        Optional<Customer> customerOptional = findByTxEmail(customerRequestDTO.getTxEmail());
        if (customerOptional.isEmpty()) {
            return customerRepository.save(customerRequestDTO.toEntity(modelMapper, customerRequestDTO));
        } else {
            throw new BusinessException(EMAIL_EXISTS);
        }

    }

    public Customer update(Long idCustomer, CustomerRequestDTO customerRequestDTO){
        Customer customer = findById(idCustomer);
        if(validateEmail(idCustomer, customer)){
            customerRequestDTO.setIdCustomer(customer.getIdCustomer());
            customer = customerRequestDTO.toEntity(modelMapper, customerRequestDTO);
            return customerRepository.save(customer);
        } else {
            throw new BusinessException(EMAIL_EXISTS);
        }
    }

    private boolean validateEmail(Long idCustomer, Customer customer){
        return findByTxEmail(customer.getTxEmail()).isEmpty()
                || idCustomer.equals(customer.getIdCustomer());
    }
}

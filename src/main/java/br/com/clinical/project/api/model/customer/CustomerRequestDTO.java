package br.com.clinical.project.api.model.customer;

import br.com.clinical.project.domain.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    private Long idCustomer;
    private String txCustomer;
    private String txPhone;
    private String txEmail;
    private LocalDate dtBirth;
    private String txObservations;

    public static CustomerRequestDTO toDto(ModelMapper modelMapper, Customer customer) {
        return modelMapper.map(customer, CustomerRequestDTO.class);
    }

    public static List<CustomerRequestDTO> listToDTO(ModelMapper modelMapper, List<Customer> customers) {
        return customers.stream()
                .map(customer -> toDto(modelMapper, customer))
                .toList();
    }

    public Customer toEntity(ModelMapper modelMapper, CustomerRequestDTO customerRequestDTO) {
        return modelMapper.map(customerRequestDTO, Customer.class);
    }
}

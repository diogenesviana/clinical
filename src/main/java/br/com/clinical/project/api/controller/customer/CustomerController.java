package br.com.clinical.project.api.controller.customer;

import br.com.clinical.project.api.model.customer.CustomerRequestDTO;
import br.com.clinical.project.api.model.material.MaterialRequestDTO;
import br.com.clinical.project.domain.model.customer.Customer;
import br.com.clinical.project.domain.model.material.Material;
import br.com.clinical.project.domain.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerRequestDTO> findById (@PathVariable Long idCustomer){
        Customer customer = customerService.findById(idCustomer);
        return ResponseEntity.ok(CustomerRequestDTO.toDto(modelMapper, customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerRequestDTO>> findAll(){
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(CustomerRequestDTO.listToDTO(modelMapper, customers));
    }

    @PostMapping
    public ResponseEntity<CustomerRequestDTO> create (@RequestBody CustomerRequestDTO customerRequestDTO){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idCustomer}")
                .buildAndExpand(CustomerRequestDTO.toDto(modelMapper, customerService.create(customerRequestDTO)))
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{idCustomer}")
    public ResponseEntity<CustomerRequestDTO> update(@PathVariable Long idCustomer, @RequestBody CustomerRequestDTO customerRequestDTO){
        Customer customer = customerService.update(idCustomer, customerRequestDTO);
        return ResponseEntity.ok(CustomerRequestDTO.toDto(modelMapper, customer));
    }
}

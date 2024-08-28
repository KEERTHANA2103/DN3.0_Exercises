package com.bookstore.controller;

import com.bookstore.dto.CustomerDTO;
import com.bookstore.mapper.CustomerMapper;
import com.bookstore.model.Customer;
import com.bookstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<EntityModel<CustomerDTO>> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO responseDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(savedCustomer);
        
        EntityModel<CustomerDTO> resource = EntityModel.of(responseDTO);
        resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).withSelfRel());
        resource.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers"));

        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CustomerDTO>> getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
                    EntityModel<CustomerDTO> resource = EntityModel.of(customerDTO);
                    resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel());
                    resource.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers"));
                    return new ResponseEntity<>(resource, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<CustomerDTO>>> getAllCustomers() {
        List<EntityModel<CustomerDTO>> customers = customerRepository.findAll().stream()
                .map(customer -> {
                    CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
                    EntityModel<CustomerDTO> resource = EntityModel.of(customerDTO);
                    resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());
                    return resource;
                })
                .collect(Collectors.toList());
        
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
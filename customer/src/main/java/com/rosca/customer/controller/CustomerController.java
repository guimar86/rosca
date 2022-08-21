package com.rosca.customer.controller;


import com.rosca.customer.model.Customer;
import com.rosca.customer.repository.impl.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<Customer> list() {

        return customerService.list();
    }

    @GetMapping("{id}")
    public Optional<Customer> find(@PathVariable long id) {

        return customerService.find(id);
    }

    @PostMapping("")
    public Customer create(@RequestBody Customer customer) {

        return customerService.create(customer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Customer> delete(@PathVariable long id) {

        customerService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}

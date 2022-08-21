package com.rosca.customer.repository.impl;


import com.rosca.customer.model.Customer;
import com.rosca.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Optional<Customer> find(long id) {

        return customerRepository.findById(id);
    }

    public Customer create(Customer customer) {

        return customerRepository.save(customer);
    }

    public void delete(long id) {

        customerRepository.deleteById(id);
    }
}

package com.rosca.customer.repository.impl;

import com.rosca.customer.dto.GroupRequest;
import com.rosca.customer.model.Customer;
import com.rosca.customer.model.Group;
import com.rosca.customer.repository.CustomerRepository;
import com.rosca.customer.repository.GroupRepository;
import com.rosca.customer.util.BorrowerOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final CustomerRepository customerRepository;

    public GroupService(GroupRepository groupRepository, CustomerRepository customerRepository) {
        this.groupRepository = groupRepository;
        this.customerRepository = customerRepository;
    }

    public List<Group> list(){

        return groupRepository.findAll();
    }

    public Group create(GroupRequest request) {

        String order= BorrowerOrder.setGroupOrder(request.getCustomers());

        var group = Group.builder()
                .customers(request.getCustomers())
                .frequency(request.getFrequency())
                .amount(request.getAmount())
                .ordem(order)
                .build();



        return groupRepository.save(group);

    }


    private boolean validateCustomersExist(List<Customer> customers) {



        return customers.stream().filter(p -> customerRepository.findById(p.getId()) != null)
                .findAny()
                .get() != null;

    }
}

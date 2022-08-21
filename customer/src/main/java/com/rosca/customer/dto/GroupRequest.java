package com.rosca.customer.dto;

import com.rosca.customer.model.Customer;
import com.rosca.customer.model.PaymentFrequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {

    private float amount;
    private Set<Customer> customers;
    private PaymentFrequency frequency;
}

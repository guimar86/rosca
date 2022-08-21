package com.rosca.customer.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(sequenceName = "customer_id_sequence", name = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private long id;

    private String name;
    private String email;
    private String telephone;
    private String iban;
    private String legalDocId;


}

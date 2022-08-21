package com.rosca.customer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "grupo")
public class Group {

    @Id
    @SequenceGenerator(name = "group_id_sequence",sequenceName = "group_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "group_id_sequence")
    private long id;

    private float amount;

    @OneToMany
    @JoinColumn(name = "grupo_id",foreignKey = @ForeignKey(name = "fk_customers"),referencedColumnName = "id")
    private Set<Customer> customers;

    private PaymentFrequency frequency;

    private String ordem;

}

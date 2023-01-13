package com.kixikila.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @Column(nullable = false)
    @NotEmpty
    private String email;
    @Column
    @NotEmpty
    @Length(min = 5)
    private String IdentificationNumber;

    @Column
    @NotEmpty
    @Length(min=5)
    private String telephoneNumber;
    @Column
    @NotEmpty
    @Length(min=15,max=33)
    private String iban;

}


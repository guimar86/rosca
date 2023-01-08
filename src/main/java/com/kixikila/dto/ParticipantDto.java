package com.kixikila.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDto {

    private String name;
    private String email;
    private String IdentificationNumber;
    private String telephoneNumber;

    private String iban;

}

package com.kixikila.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kixikila.dto.ParticipantDto;
import com.kixikila.model.Participant;
import com.kixikila.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository repository;


    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public Participant createParticipant(ParticipantDto participantDto) {

        ObjectMapper mapper = new ObjectMapper();

        Participant participant = mapper.convertValue(participantDto, Participant.class);
        return repository.save(participant);
    }

    public List<Participant> participantList(){

        return repository.findAll();
    }


}

package com.kixikila.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kixikila.dto.ParticipantDto;
import com.kixikila.exception.ParticipantNotFoundExeption;
import com.kixikila.exception.RoscaException;
import com.kixikila.model.Participant;
import com.kixikila.repository.ParticipantRepository;
import com.kixikila.service.validation.ParticipantValidationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository repository;
    private final ParticipantValidationService<Participant> validationService;

    public ParticipantService(ParticipantRepository repository, ParticipantValidationService<Participant> validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Participant createParticipant(ParticipantDto participantDto) {

        ObjectMapper mapper = new ObjectMapper();

        Participant participant = mapper.convertValue(participantDto, Participant.class);
        var validations = validationService.validate(participant);

        if (!CollectionUtils.isEmpty(validations)) {
            RoscaException exception = new RoscaException("Failed validations");
            exception.validations = validations;
            throw exception;
        }
        return repository.save(participant);
    }

    public List<Participant> participantList() {

        return repository.findAll();
    }

    public Participant findParticipant(long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundExeption(id));
    }

}

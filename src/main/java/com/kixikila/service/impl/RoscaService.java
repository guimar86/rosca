package com.kixikila.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kixikila.dto.ParticipantDto;
import com.kixikila.dto.RoscaDto;
import com.kixikila.model.Participant;
import com.kixikila.model.Rosca;
import com.kixikila.repository.ParticipantRepository;
import com.kixikila.repository.RoscaRepository;
import com.kixikila.service.IRosca;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoscaService implements IRosca {

    private final RoscaRepository repository;
    private final ParticipantRepository participantRepository;

    public RoscaService(RoscaRepository roscaRepository, ParticipantRepository participantRepository) {
        this.repository = roscaRepository;
        this.participantRepository = participantRepository;
    }

    public Rosca createRosca(RoscaDto roscaDto) {

        ObjectMapper mapper = new ObjectMapper();
        Rosca rosca = mapper.convertValue(roscaDto, Rosca.class);
        return repository.save(rosca);
    }

    public List<Rosca> listRosca() {

        return repository.findAll();
    }

    public Optional<Rosca> findRosca(long id) {

        return repository.findById(id);
    }

    public Rosca addParticipant(long id, ParticipantDto participantDto) {

        ObjectMapper mapper = new ObjectMapper();

        Participant participant;
        participant = participantRepository.findByEmail(participantDto.getEmail());
        var rosca = repository.findById(id);

        if (rosca.isPresent() && participant != null) {
            rosca.get().getParticipants().add(participant);
            repository.save(rosca.get());
            return rosca.get();
        }

        if (rosca.isPresent()){

            participant=mapper.convertValue(participantDto,Participant.class);
            rosca.get().getParticipants().add(participant);
            repository.save(rosca.get());
            return rosca.get();
        }

        return null;
    }

    @Override
    public int calculateMonthlyPayout(Rosca rosca, Participant participant) {
        int index = rosca.getParticipants().indexOf(participant);
        return rosca.getContributionAmount() * (rosca.getParticipants().size() - index);
    }

    @Override
    public Participant getNextParticipant(Rosca rosca) {
        Participant nextParticipant = rosca.getParticipants().get(rosca.getCurrentTurn());
        var turn = (rosca.getCurrentTurn() + 1) % rosca.getParticipants().size();
        rosca.setCurrentTurn(turn); //save to database
        return nextParticipant;
    }
}

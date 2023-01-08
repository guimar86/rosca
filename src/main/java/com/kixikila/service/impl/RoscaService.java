package com.kixikila.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kixikila.dto.RoscaDto;
import com.kixikila.model.Participant;
import com.kixikila.model.Rosca;
import com.kixikila.repository.RoscaRepository;
import com.kixikila.service.IRosca;
import org.springframework.stereotype.Service;

@Service
public class RoscaService implements IRosca {

    private final RoscaRepository repository;

    public RoscaService(RoscaRepository roscaRepository) {
        this.repository = roscaRepository;
    }

    public Rosca createRosca(RoscaDto roscaDto){

        ObjectMapper mapper=new ObjectMapper();
        Rosca rosca= mapper.convertValue(roscaDto,Rosca.class);
        return repository.save(rosca);
    }

    @Override
    public int calculateMonthlyPayout(Rosca rosca, Participant participant) {
        int index = rosca.getParticipants().indexOf(participant);
        return rosca.getContributionAmount() * (rosca.getParticipants().size() - index);
    }

    @Override
    public Participant getNextParticipant(Rosca rosca) {
        Participant nextParticipant =rosca.getParticipants().get(rosca.getCurrentTurn());
        var turn = (rosca.getCurrentTurn() + 1) % rosca.getParticipants().size();
        rosca.setCurrentTurn(turn); //save to database
        return nextParticipant;
    }
}

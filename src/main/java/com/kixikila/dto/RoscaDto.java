package com.kixikila.dto;


import com.kixikila.model.Participant;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoscaDto {

    private String name;
    private List<ParticipantDto> participants;
    private int contributionAmount;
    private int currentTurn;
}

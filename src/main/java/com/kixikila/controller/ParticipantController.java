package com.kixikila.controller;


import com.kixikila.dto.ParticipantDto;
import com.kixikila.model.Participant;
import com.kixikila.service.impl.ParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }


    @PostMapping("")
    public Participant createParticipant(@RequestBody
                                         ParticipantDto participantDto){

        return participantService.createParticipant(participantDto);
    }

    @GetMapping("")
    public List<Participant> listParticipants(){
        return participantService.participantList();
    }
    
}

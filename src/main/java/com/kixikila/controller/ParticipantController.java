package com.kixikila.controller;


import com.kixikila.dto.ParticipantAssembler;
import com.kixikila.dto.ParticipantDto;
import com.kixikila.model.Participant;
import com.kixikila.service.impl.ParticipantService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/participants")
public class ParticipantController {

    private final ParticipantService participantService;
    private final ParticipantAssembler participantAssembler;

    public ParticipantController(ParticipantService participantService, ParticipantAssembler participantAssembler) {
        this.participantService = participantService;
        this.participantAssembler = participantAssembler;
    }


    @PostMapping("")
    public ResponseEntity<?> createParticipant(@RequestBody
                                         ParticipantDto participantDto) {


        var participant= participantAssembler.toModel(participantService.createParticipant(participantDto));
        return ResponseEntity
                .created(participant.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(participant);
    }

    @GetMapping()
    public CollectionModel<EntityModel<Participant>> listParticipants() {

        List<EntityModel<Participant>> participants = participantService.participantList().stream().map(participantAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(participants,
                linkTo(methodOn(ParticipantController.class).listParticipants()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Participant> findParticipant(@PathVariable long id) {
        var participant = participantService.findParticipant(id);
        return participantAssembler.toModel(participant);

    }

}

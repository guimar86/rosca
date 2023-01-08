package com.kixikila.dto;

import com.kixikila.controller.ParticipantController;
import com.kixikila.model.Participant;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ParticipantAssembler implements RepresentationModelAssembler<Participant, EntityModel<Participant>> {
    @Override
    public EntityModel<Participant> toModel(Participant participant) {
        return EntityModel.of(participant,
                linkTo(methodOn(ParticipantController.class).findParticipant(participant.getId())).withSelfRel(),
                linkTo(methodOn(ParticipantController.class).listParticipants()).withRel("participants")
        );
    }
}

package com.kixikila.dto;

import com.kixikila.controller.RoscaController;
import com.kixikila.model.Rosca;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RoscaAssembler implements RepresentationModelAssembler<Rosca, EntityModel<Rosca>> {
    @Override
    public EntityModel<Rosca> toModel(Rosca rosca) {
        return EntityModel.of(rosca,
                linkTo(methodOn(RoscaController.class).findRosca(rosca.getId())).withSelfRel(),
                linkTo(methodOn(RoscaController.class).listRosca()).withRel("roscas"));
    }
}

package com.kixikila.controller;

import com.kixikila.dto.RoscaAssembler;
import com.kixikila.dto.RoscaDto;
import com.kixikila.model.Rosca;
import com.kixikila.service.impl.RoscaService;
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
@RequestMapping("api/v1/rosca")
public class RoscaController {

    private final RoscaService roscaService;
    private final RoscaAssembler roscaAssembler;

    public RoscaController(RoscaService roscaService, RoscaAssembler roscaAssembler) {
        this.roscaService = roscaService;
        this.roscaAssembler = roscaAssembler;
    }

    @PostMapping()
    public ResponseEntity<?> createRosca(@RequestBody RoscaDto roscaDto) {

        var rosca = roscaAssembler.toModel(roscaService.createRosca(roscaDto));
        return ResponseEntity
                .created(rosca.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(rosca);

    }

    @GetMapping()
    public CollectionModel<EntityModel<Rosca>> listRosca() {

        List<EntityModel<Rosca>> roscas=roscaService.listRosca().stream().map(roscaAssembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(roscas,
                linkTo(methodOn(RoscaController.class).listRosca()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Rosca> findRosca(@PathVariable long id) {

        var rosca=roscaService.findRosca(id);
        return roscaAssembler.toModel(rosca.get());

    }
}

package com.rosca.customer.controller;

import com.rosca.customer.dto.GroupRequest;
import com.rosca.customer.model.Group;
import com.rosca.customer.repository.impl.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/groups")
public class GroupController {


    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("")
    public List<Group> list() {

        return groupService.list();
    }

    @PostMapping("")
    public Group create(@RequestBody GroupRequest request){

        return groupService.create(request);
    }
}

package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private Validator validator;

    @RequestMapping(method = RequestMethod.GET, value = "groups")
    public List<GroupDto> getGroups(){
        return groupService.getAllGroups();
    }

    @RequestMapping(method = RequestMethod.GET, value = "groups/{groupId}")
    public GroupDto getGroup (@PathVariable Long groupId){
        validator.validateGroupById(groupId);
        return groupService.getGroupById(groupId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "groups/{groupId}")
    public void deleteGroup(@PathVariable Long groupId){
        validator.validateGroupById(groupId);
        groupService.deleteGroup(groupId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "groups")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        validator.validateGroupById(groupDto.getId());
        return groupService.saveGroup(groupDto);
    }


    @RequestMapping(method = RequestMethod.POST, value = "groups", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupdDto){
        groupService.saveGroup(groupdDto);
    }
}

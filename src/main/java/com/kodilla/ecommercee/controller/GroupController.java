package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/v1/ecommercee")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "groups")
    public List<GroupDto> getGroups(){
        List<GroupDto> groupDtos = new ArrayList<>();
        groupDtos.add(new GroupDto(1L,"Kurtki"));
        groupDtos.add(new GroupDto(2L,"Płaszcze"));
        return groupDtos;
    }

    @RequestMapping(method = RequestMethod.GET, value = "groups/{groupId}")
    public GroupDto getGroup (@PathVariable Long groupId){
        return new GroupDto(1L,"Kurtki");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "groups/{groupId}")
    public void deleteGroup(@PathVariable Long groupId){
    }

    @RequestMapping(method = RequestMethod.PUT, value = "groups")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return new GroupDto(1L, "Jednak plecaki");
    }

    @RequestMapping(method = RequestMethod.POST, value = "groups")
    public void createGroup(@RequestBody GroupDto groupdDto){
    }
}

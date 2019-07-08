package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    GroupMapper groupMapper;

    public List<GroupDto> getAllGroups() {
        List<GroupEntity> groups = groupRepository.findAll();
        return groupMapper.mapToGroupDtoList(groups);
    }

    public GroupDto getGroupById(Long groupId) {
        GroupEntity group = groupRepository.getById(groupId).get();
        return groupMapper.mapToGroupDto(group);
    }

    public GroupDto saveGroup(GroupDto groupDto) {
        GroupEntity group = groupMapper.mapToGroupEntity(groupDto);
        return groupMapper.mapToGroupDto(groupRepository.save(group));
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    public boolean isExist(Long groupId) {
        return groupRepository.existsById(groupId);
    }
}

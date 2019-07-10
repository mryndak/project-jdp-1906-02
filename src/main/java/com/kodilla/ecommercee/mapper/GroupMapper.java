package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public GroupDto mapToGroupDto(GroupEntity groupEntity) {
        return new GroupDto(
                groupEntity.getId(),
                groupEntity.getName()
        );
    }

    public GroupEntity mapToGroupEntity(GroupDto groupDto) {
        return new GroupEntity(
                groupDto.getId(),
                groupDto.getName(),
                new ArrayList<>()
        );
    }

    public List<GroupDto> mapToGroupDtoList(List<GroupEntity> groups) {
        return groups.stream()
                .map(group -> mapToGroupDto(group))
                .collect(Collectors.toList());
    }
}

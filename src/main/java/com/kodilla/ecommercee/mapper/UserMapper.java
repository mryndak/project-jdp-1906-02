package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserEntity;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToUserEntity(UserDto userDto) {
        return new UserEntity(
                userDto.getId(),
                userDto.getUsername(),
                userDto.isStatus(),
                userDto.getUserKey()
        );
    }

    public UserDto mapToUserDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.isState(),
                userEntity.getUserKey()
        );
    }
}

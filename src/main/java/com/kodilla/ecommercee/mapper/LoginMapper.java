package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.LoginEntity;
import com.kodilla.ecommercee.dto.LoginDto;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    @Autowired
    private UserRepository userRepository;

    public LoginEntity mapToLoginEntity(LoginDto loginDto) {
        return new LoginEntity(
                loginDto.getId(),
                loginDto.getSessionId(),
                loginDto.isLoggedIn(),
                userRepository.findById(loginDto.getUserId()).get()
        );
    }

    public LoginDto mapToLoginDto(LoginEntity loginEntity) {
        return new LoginDto(
                loginEntity.getLoginId(),
                loginEntity.isLoggedIn(),
                loginEntity.getSessionId(),
                loginEntity.getUser().getId()
        );
    }
}

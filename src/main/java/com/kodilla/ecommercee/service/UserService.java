package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.LoginEntity;
import com.kodilla.ecommercee.domain.UserEntity;
import com.kodilla.ecommercee.dto.LoginDto;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.mapper.LoginMapper;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.LoginRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class UserService {

    @Autowired
    private Random generator;

    @Autowired
    private Timer timer;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginMapper loginMapper;

    public UserDto saveUser(UserDto userDto) {
        UserEntity user = userRepository.save(userMapper.mapToUserEntity(userDto));
        return userMapper.mapToUserDto(user);
    }

    public UserDto getUser(Long userId) {
        return userMapper.mapToUserDto(userRepository.findById(userId).get());
    }

    public boolean isExist(Long userId) {
        return userRepository.existsById(userId);
    }

    public LoginDto createLogin(Long userId) {
        int generateValue = generator.nextInt(100000);
        String key = String.format("%05d", generateValue);
        LoginEntity login = loginRepository.save(new LoginEntity(
                key,
                true,
                userRepository.findById(userId).get()));
        LoginDto loginDto = loginMapper.mapToLoginDto(login);
        oneOurTimer(loginDto);
        return loginDto;
    }

    public void oneOurTimer(LoginDto loginDto) {
        TimerTask task =  new TimerTask() {
            @Override
            public void run() {
                loginDto.setLoggedIn(false);
                loginRepository.save(loginMapper.mapToLoginEntity(loginDto));
            }
        };
        timer.schedule(task, 3600000);
    }

}

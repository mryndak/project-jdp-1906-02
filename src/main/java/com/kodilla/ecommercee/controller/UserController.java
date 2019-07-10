package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.LoginDto;
import com.kodilla.ecommercee.service.UserService;
import com.kodilla.ecommercee.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;

    @RequestMapping(method = RequestMethod.POST, value = "users", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "users/{userId}")
    public UserDto lockUser(@PathVariable Long userId, @RequestParam boolean status) {
        validator.validateUserId(userId);
        UserDto userDto = userService.getUser(userId);
        userDto.setStatus(status);
        userService.saveUser(userDto);
        return userDto;
    }

    @RequestMapping(method = RequestMethod.POST, value = "users/{userId}/keys")
    public LoginDto generateKey(@PathVariable Long userId, @RequestParam String username, @RequestParam String userKey) {
        validator.validateUserId(userId);
        UserDto userDto = userService.getUser(userId);
        validator.validateUserActive(userDto);
        validator.validateUserData(userDto, username, userKey);
        return userService.createLogin(userId);
    }

}

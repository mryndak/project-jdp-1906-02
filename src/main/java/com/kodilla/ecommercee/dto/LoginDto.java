package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginDto {
    private Long id;
    private boolean loggedIn;
    private String sessionId;
    private Long userId;

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}

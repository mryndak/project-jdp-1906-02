package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginEntity {

    @Id
    @GeneratedValue
    private Long loginId;

    private String sessionId;

    private boolean loggedIn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public LoginEntity(String sessionId, boolean loggedIn, UserEntity user) {
        this.sessionId = sessionId;
        this.loggedIn = loggedIn;
        this.user = user;
    }
}

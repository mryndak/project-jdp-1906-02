package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String username;
    private boolean status;
    private String userKey;
    private Long cartId;
    private List<Long> orderIds;
    private List<Long> loginIds;

    public UserDto(Long id, String username, boolean status, String userKey) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

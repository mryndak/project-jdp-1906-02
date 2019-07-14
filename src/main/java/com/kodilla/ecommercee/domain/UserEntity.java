package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private boolean state;

    private String userKey;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @OneToMany (
            targetEntity = OrderEntity.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderEntity> orders;

    @OneToMany (
            targetEntity = LoginEntity.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<LoginEntity> logins;

    public UserEntity(Long id, String username, boolean state, String userKey) {
        this.id = id;
        this.username = username;
        this.state = state;
        this.userKey = userKey;
    }
}

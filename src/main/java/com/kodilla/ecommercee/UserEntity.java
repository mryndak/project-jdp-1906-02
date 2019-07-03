package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private boolean state;

    private int userKey;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//
//    @OneToMany (
//            targetEntity = Order.class,
//            mappedBy = "user_id",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    private List<Order> orderList;

}

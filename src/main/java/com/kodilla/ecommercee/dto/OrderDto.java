package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.CartEntity;
import com.kodilla.ecommercee.domain.ItemEntity;
import com.kodilla.ecommercee.domain.OrderStatus;
import com.kodilla.ecommercee.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Long userId;
    private Long cartId;
    private List<ItemEntity> products;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private BigDecimal totalOrder;
}

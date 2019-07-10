package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderEntity;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public OrderDto mapToOrderDto(OrderEntity orderEntity) {
        return new OrderDto(
                orderEntity.getId(),
                orderEntity.getUser().getId(),
                orderEntity.getCart().getId(),
                orderEntity.getProducts(),
                orderEntity.getOrderDate(),
                orderEntity.getOrderStatus(),
                orderEntity.getTotalOrder()
        );
    }

    public OrderEntity mapToOrderEntity(OrderDto orderDto) {
        return new OrderEntity(
                orderDto.getId(),
                userRepository.getOne(orderDto.getUserId()),
                cartRepository.getOne(orderDto.getCartId()),
                orderDto.getProducts(),
                orderDto.getOrderDate(),
                orderDto.getOrderStatus(),
                orderDto.getTotalOrder()
        );
    }

    public List<OrderDto> mapToOrderDtoList(List<OrderEntity> orders) {
        return orders.stream()
                .map(order -> mapToOrderDto(order))
                .collect(Collectors.toList());
    }
}
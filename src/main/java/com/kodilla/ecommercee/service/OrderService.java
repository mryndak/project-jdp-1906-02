package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.OrderEntity;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orderMapper.mapToOrderDtoList(orders);
    }

    public OrderDto getOrderById(Long productId) {
        OrderEntity order = orderRepository.findById(productId).get();
        return orderMapper.mapToOrderDto(order);
    }

    public OrderDto saveOrder(OrderDto orderDto) {
        OrderEntity order = orderMapper.mapToOrderEntity(orderDto);
        return orderMapper.mapToOrderDto(orderRepository.save(order));
    }

    public void deleteOrder(Long productId) {
        orderRepository.deleteById(productId);
    }

    public boolean isExist(Long productId) {
        return orderRepository.existsById(productId);
    }
}

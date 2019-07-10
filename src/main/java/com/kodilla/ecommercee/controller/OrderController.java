package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.service.OrderService;
import com.kodilla.ecommercee.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee/users")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Validator validator;

    @RequestMapping(method = RequestMethod.GET, value = "{userId}/orders")
    public List<OrderDto> getAllOrders(@PathVariable Long userId) {
        return orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.POST, value = "{userId}/orders", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@PathVariable Long userId, @RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{userId}/orders/{orderId}")
    public OrderDto getOrder(@PathVariable Long userId, @PathVariable Long orderId) {
        validator.validateOrderId(orderId);
        return orderService.getOrderById(orderId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{userId}/orders")
    public OrderDto updateOrder(@PathVariable Long userId, @RequestBody OrderDto orderDto) {
        validator.validateOrderId(orderDto.getId());
        return orderService.saveOrder(orderDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{userId}/orders/{orderId}")
    public void deleteOrder(@PathVariable Long userId, @PathVariable Long orderId) {
        validator.validateOrderId(orderId);
        orderService.deleteOrder(orderId);
    }
}

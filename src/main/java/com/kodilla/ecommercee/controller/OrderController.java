package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.kodilla.ecommercee.domain.OrderStatus.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee/users")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "{userId}/orders")
    public List<OrderDto> getAllOrders(@PathVariable Long userId) {
        List<OrderDto> orderList = new ArrayList<>();
        orderList.add(new OrderDto(1L, 1L, 1L,  new ArrayList<>(), LocalDateTime.of(2019,6,25,16,49), CREATED, new BigDecimal(4)));
        orderList.add(new OrderDto(2L, 2L, 2L,  new ArrayList<>(), LocalDateTime.of(2019,6,26,17,49), CREATED, new BigDecimal(17)));
        return orderList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "{userId}/orders", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@PathVariable Long userId, @RequestBody OrderDto orderDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "{userId}/orders/{orderId}")
    public OrderDto getOrder(@PathVariable Long userId, @PathVariable Long orderId) {
        return new OrderDto(1L, 1L, 1L,  new ArrayList<>(), LocalDateTime.of(2019,6,25,16,49), CREATED, new BigDecimal(4));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{userId}/orders")
    public OrderDto updateOrder(@PathVariable Long userId, @RequestBody OrderDto orderDto) {
        return new OrderDto(1L, 1L, 1L,  new ArrayList<>(), LocalDateTime.of(2019,6,25,16,55), PAID, new BigDecimal(4));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{userId}/orders/{orderId}")
    public void deleteOrder(@PathVariable Long userId, @PathVariable Long orderId) {
    }
}

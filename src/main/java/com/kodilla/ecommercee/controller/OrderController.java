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
@RequestMapping("/v1/ecommercee")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getAllOrders")
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orderList = new ArrayList<>();
        orderList.add(new OrderDto(1L, 1L, 1L,  new ArrayList<>(), LocalDateTime.of(2019,6,25,16,49), CREATED, new BigDecimal(4)));
        orderList.add(new OrderDto(2L, 2L, 2L,  new ArrayList<>(), LocalDateTime.of(2019,6,26,17,49), CREATED, new BigDecimal(17)));
        return orderList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {
        return new OrderDto(1L, 1L, 1L,  new ArrayList<>(), LocalDateTime.of(2019,6,25,16,49), CREATED, new BigDecimal(4));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, 1L, 1L,  new ArrayList<>(), LocalDateTime.of(2019,6,25,16,55), PAID, new BigDecimal(4));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
    }
}

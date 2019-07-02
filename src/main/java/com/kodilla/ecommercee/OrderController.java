package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.kodilla.ecommercee.OrderStatus.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getAllOrders")
    public List<OrderDto> getAllOrders() {
        return new ArrayList<>();
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

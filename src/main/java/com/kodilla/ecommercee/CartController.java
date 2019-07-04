package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestParam Long userId) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCartsContent")
    public List<Item> getCart(@RequestParam Long cartId) {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addToCart")
    public void addProduct(@RequestParam Long cartId, @RequestBody String productName, Integer quantity) {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestBody String productName) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "createNewOrder")
    public OrderDto createOrder(@RequestParam Long cartId) {
        List<Item> itemList = new ArrayList<>();
        return new OrderDto(44256L, 122L, 7404L, itemList, LocalDateTime.now(), OrderStatus.CREATED, new BigDecimal(1208));
    }
}
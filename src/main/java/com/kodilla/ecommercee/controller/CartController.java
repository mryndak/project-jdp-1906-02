package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.domain.ItemEntity;
import com.kodilla.ecommercee.domain.OrderStatus;
import com.kodilla.ecommercee.domain.ProductEntity;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/users")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "{userId}/carts")
    public CartDto createCart(@PathVariable Long userId) {
        return new CartDto(1L, userId, new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.GET, value = "{userId}/carts")
    public List<ItemEntity> getCart(@PathVariable Long userId) {
        List<ItemEntity> itemEntityList = new ArrayList<>();
        itemEntityList.add(new ItemEntity(1L, 2, 20, new ProductEntity(3L, "product7", "blue T-shirt", new BigDecimal(10),
                new GroupEntity(5L, "Clothes", new ArrayList<>()))));
        itemEntityList.add(new ItemEntity(4L, 5, 125, new ProductEntity(7L, "product22", "red skirt", new BigDecimal(25),
                new GroupEntity(5L, "Clothes", new ArrayList<>()))));
        return itemEntityList;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{userId}/carts")
    public void addProduct(@PathVariable Long userId, @RequestBody String productName, Integer quantity) {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{userId}/carts/{itemId}")
    public void deleteProductFromCart(@PathVariable Long userId, @PathVariable Long itemId) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "{userId}/orders")
    public OrderDto createOrder(@PathVariable Long userId) {
        List<ItemEntity> itemEntityList = new ArrayList<>();
        return new OrderDto(44256L, 122L, 7404L, itemEntityList, LocalDateTime.now(), OrderStatus.CREATED, new BigDecimal(1208));
    }
}
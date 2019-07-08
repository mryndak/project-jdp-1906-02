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
@RequestMapping("/v1/ecommercee")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public CartDto createCart(@RequestParam Long userId) {
        return new CartDto(1L, userId, new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCartsContent")
    public List<ItemEntity> getCart(@RequestParam Long cartId) {
        List<ItemEntity> itemEntityList = new ArrayList<>();
        itemEntityList.add(new ItemEntity(1L, 2, 20, new ProductEntity(3L, "product7", "blue T-shirt", new BigDecimal(10),
                new GroupEntity(5L, "Clothes", new ArrayList<>()))));
        itemEntityList.add(new ItemEntity(4L, 5, 125, new ProductEntity(7L, "product22", "red skirt", new BigDecimal(25),
                new GroupEntity(5L, "Clothes", new ArrayList<>()))));
        return itemEntityList;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addToCart")
    public void addProduct(@RequestParam Long cartId, @RequestBody String productName, Integer quantity) {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestBody String productName) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "createNewOrder")
    public OrderDto createOrder(@RequestParam Long cartId) {
        List<ItemEntity> itemEntityList = new ArrayList<>();
        return new OrderDto(44256L, 122L, 7404L, itemEntityList, LocalDateTime.now(), OrderStatus.CREATED, new BigDecimal(1208));
    }
}
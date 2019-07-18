package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderStatus;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.ItemDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.mapper.ItemMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ProductService;
import com.kodilla.ecommercee.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/users")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private Validator validator;

    @Autowired
    private ProductService productService;

    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping(method = RequestMethod.POST, value = "{userId}/carts")
    public void createCart(@PathVariable Long userId) {
        cartService.saveCart(new CartDto(userId));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{userId}/carts/{cartId}")
    public CartDto addProduct(@PathVariable Long userId, @PathVariable Long cartId, @RequestBody ItemDto itemDto) {
        validator.validateUserId(userId);
        validator.validateCartById(cartId);
        validator.validateProductId(itemDto.getProductId());
        CartDto cart = cartService.getCartById(cartId);
        cartService.addItem(itemDto, cart);
        return cartService.saveCart(cart);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "{id}/carts/{itemId}")
    public void deleteProductFromCart(@PathVariable Long id, @PathVariable Long itemId) {
        validator.validateCartById(id);
        validator.validateItemById(itemId);
        cartService.deleteFromCart(id, itemId);

    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}/carts")
    public List<ItemDto> getCart(@PathVariable Long id) {
        validator.validateCartById(id);
        return cartService.getCart(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "{cartId}/orders")
    public OrderDto createOrder(@PathVariable Long cartId) {
        validator.validateCartById(cartId);
        OrderDto order = new OrderDto(1L, cartService.getCartById(cartId).getUserId(), cartId,
                itemMapper.mapToItemEntityList(cartService.getCartById(cartId).getItemDtoList()),
                LocalDateTime.now(), OrderStatus.CREATED, cartService.getCartById(cartId).getTotalCost());
        return order;
    }
}
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.PUT, value = "{id}/carts/{quantity}/{productId}")
    public CartDto addProduct(@PathVariable Long id, @PathVariable int quantity, @PathVariable Long productId) {
        validator.validateCartById(id);
        validator.validateProductId(productId);
        ItemDto item = new ItemDto(quantity, productId);
        BigDecimal total = productService.getProductById(productId).getPrice();
        total = total.multiply(new BigDecimal(quantity));
        item.setTotal(total);
        List<ItemDto> itemDtos = cartService.getCartById(id).getItemDtoList();
        itemDtos.add(item);
        BigDecimal totalCost = cartService.getCartById(id).getTotalCost();
        totalCost = totalCost.add(item.getTotal());
        CartDto cart = new CartDto(id, cartService.getCartById(id).getUserId(), itemDtos, totalCost);
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
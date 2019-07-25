package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.CartEntity;
import com.kodilla.ecommercee.domain.ItemEntity;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.ItemDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ItemMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ItemRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ProductRepository productRepository;

    public CartDto saveCart(CartDto cartDto) {
        CartEntity cart = cartRepository.save(cartMapper.mapToCartEntity(cartDto));
        return cartMapper.mapToCartDto(cart);
    }

    public List<ItemDto> getCart(Long cartId) {
        List<ItemEntity> items = itemMapper.mapToItemEntityList(getCartById(cartId).getItemDtoList());
        return itemMapper.mapToItemDtoList(items);
    }

    public CartDto getCartById(Long cartId) {
        CartEntity cart = cartRepository.findById(cartId).get();
        return cartMapper.mapToCartDto(cart);
    }

    public void addItem(ItemDto itemDto, CartDto cartDto) {
        BigDecimal total = productRepository.getOne(itemDto.getProductId()).getPrice().multiply(new BigDecimal(itemDto.getQuantity()));
        itemDto.setTotal(total);
        cartDto.setTotalCost(cartDto.getTotalCost().add(total));
        cartDto.getItemDtoList().add(itemDto);
    }

    public void deleteFromCart(Long cartId, Long itemId) {
        CartEntity cart = cartRepository.getOne(cartId);
        BigDecimal total = cartRepository.getOne(cartId).getTotalCost();
        cart.setTotalCost(total.subtract(itemRepository.getOne(itemId).getTotal()));
        cart.getItems().remove(itemRepository.getOne(itemId));
        cartRepository.save(cart);
    }

    public boolean doesExist(Long cartId) {
        return cartRepository.existsById(cartId);
    }
}
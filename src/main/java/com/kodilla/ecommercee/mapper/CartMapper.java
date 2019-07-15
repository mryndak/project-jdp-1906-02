package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartEntity;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemMapper itemMapper;

    public CartEntity mapToCartEntity(CartDto cartDto) {
        return new CartEntity(
                cartDto.getId(),
                userRepository.getOne(cartDto.getUserId()),
                itemMapper.mapToItemEntityList(cartDto.getItemDtoList()),
                cartDto.getTotalCost()
        );
    }

    public CartDto mapToCartDto(CartEntity cartEntity) {
        return new CartDto(
                cartEntity.getId(),
                cartEntity.getUser().getId(),
                itemMapper.mapToItemDtoList(cartEntity.getItems()),
                cartEntity.getTotalCost()
        );
    }
}

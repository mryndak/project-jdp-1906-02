package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ItemEntity;
import com.kodilla.ecommercee.dto.ItemDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    @Autowired
    private ProductRepository productRepository;

    public ItemEntity mapToItemEntity(ItemDto itemDto) {
        return new ItemEntity(
                itemDto.getId(),
                itemDto.getQuantity(),
                itemDto.getTotal(),
                productRepository.getOne(itemDto.getProductId())
        );
    }

    public ItemDto mapToItemDto(ItemEntity itemEntity) {
        return new ItemDto(
                itemEntity.getId(),
                itemEntity.getQuantity(),
                itemEntity.getTotal(),
                itemEntity.getProduct().getId()
        );
    }

    public List<ItemEntity> mapToItemEntityList(List<ItemDto> itemDtos) {
        return itemDtos.stream()
                .map(item -> mapToItemEntity(item))
                .collect(Collectors.toList());
    }

    public List<ItemDto> mapToItemDtoList(List<ItemEntity> itemEntities) {
        return itemEntities.stream()
                .map(item -> mapToItemDto(item))
                .collect(Collectors.toList());
    }
}

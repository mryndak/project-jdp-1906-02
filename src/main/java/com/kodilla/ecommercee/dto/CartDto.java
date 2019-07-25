package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CartDto {
    private Long id;
    private Long userId;
    private List<ItemDto> itemDtoList;
    private BigDecimal totalCost;

    public CartDto(Long userId) {
        this.userId = userId;
        this.itemDtoList = new ArrayList<>();
        this.totalCost = new BigDecimal(0);
    }
}
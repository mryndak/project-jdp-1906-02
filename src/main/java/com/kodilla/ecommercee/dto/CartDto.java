package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private Long userId;
    private List<ItemEntity> itemEntityList;
}
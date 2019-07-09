package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductEntity;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private GroupRepository groupRepository;

    public ProductDto mapToProductDto(ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getGroup().getId()
        );
    }

    public ProductEntity mapToProductEntity(ProductDto productDto) {
        return new ProductEntity(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                groupRepository.getOne(productDto.getGroupId())
        );
    }

    public List<ProductDto> mapToProductDtoList(List<ProductEntity> products) {
        return products.stream()
                .map(product -> mapToProductDto(product))
                .collect(Collectors.toList());
    }
}

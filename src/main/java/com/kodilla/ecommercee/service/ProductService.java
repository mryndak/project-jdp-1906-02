package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts() {
        return productMapper.mapToProductDtoList(productRepository.findAll());
    }

    public ProductDto getProductById(Long productId) {
        return productMapper.mapToProductDto(productRepository.findById(productId).get());
    }

    public ProductDto saveProduct(ProductDto productDto) {
        return productMapper.mapToProductDto(productRepository.save(productMapper.mapToProductEntity(productDto)));
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public boolean isExist(Long productId) {
        return productRepository.existsById(productId);
    }
}

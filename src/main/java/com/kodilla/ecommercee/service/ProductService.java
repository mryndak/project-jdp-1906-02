package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.ProductEntity;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return productMapper.mapToProductDtoList(products);
    }

    public ProductDto getProductById(Long productId) {
        ProductEntity product = productRepository.findById(productId).get();
        return productMapper.mapToProductDto(product);
    }

    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity product = productMapper.mapToProductEntity(productDto);
        return productMapper.mapToProductDto(productRepository.save(product));
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public boolean isExist(Long productId) {
        return productRepository.existsById(productId);
    }
}

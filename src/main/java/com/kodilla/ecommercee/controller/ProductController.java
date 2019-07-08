package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "products")
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto(1L, "first name", "test description", new BigDecimal("10.0"), 1L));
        productDtos.add(new ProductDto(2L, "second name", "test description", new BigDecimal("30.0"), 3L));
        return productDtos;
    }

    @RequestMapping(method = RequestMethod.GET, value = "products/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1L, "name", "test description", new BigDecimal("10.0"), 1L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "products", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "products", consumes = APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return new ProductDto(1L, "edited name", "test description", new BigDecimal("20.0"), 1L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {

    }
}

package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.service.ProductService;
import com.kodilla.ecommercee.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Validator validator;

    @RequestMapping(method = RequestMethod.GET, value = "products")
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }


    @RequestMapping(method = RequestMethod.GET, value = "products/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {

        validator.validateProductId(productId);
        return productService.getProductById(productId);
    }


    @RequestMapping(method = RequestMethod.POST, value = "products", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {

        productService.saveProduct(productDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "products", consumes = APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        validator.validateProductId(productDto.getId());
        return productService.saveProduct(productDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {

        validator.validateProductId(productId);
        productService.deleteProduct(productId);
    }
}

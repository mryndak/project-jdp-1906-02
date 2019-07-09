package com.kodilla.ecommercee.validator;

import com.kodilla.ecommercee.exception.WrongIdException;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    private ProductService productService;

    public void validateProductId(Long productId) {
        if(!productService.isExist(productId)) {
            throw new WrongIdException("Wrong product id");
        }
    }
}

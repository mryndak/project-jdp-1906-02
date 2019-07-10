package com.kodilla.ecommercee.validator;

import com.kodilla.ecommercee.exception.WrongIdException;
import com.kodilla.ecommercee.service.OrderService;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    public void validateProductId(Long productId) {
        if(!productService.isExist(productId)) {
            throw new WrongIdException("Wrong product id");
        }
    }

    public void validateOrderId(Long orderId) {
        if(!orderService.isExist(orderId)) {
            throw new WrongIdException("Wrong order id");
        }
    }
}

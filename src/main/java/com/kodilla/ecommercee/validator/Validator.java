package com.kodilla.ecommercee.validator;

import com.kodilla.ecommercee.exception.WrongIdException;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    private ProductService productService;

    @Autowired
    private GroupService groupService;

    public void validateProductId(Long productId) {
        if(!productService.isExist(productId)) {
            throw new WrongIdException("Wrong product id");
        }
    }

    public void validateGroupById(Long groupId){
        if(!groupService.isExist(groupId)){
            throw new WrongIdException("Wrong group id");
        }
    }
}

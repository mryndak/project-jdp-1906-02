package com.kodilla.ecommercee.validator;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.UserBlockedException;
import com.kodilla.ecommercee.exception.WrongDataException;
import com.kodilla.ecommercee.exception.WrongIdException;
import com.kodilla.ecommercee.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;


    public void validateProductId(Long productId) {
        if (!productService.isExist(productId)) {
            throw new WrongIdException("Wrong product id");
        }
    }


    public void validateUserId(Long userId) {
        if (!userService.isExist(userId)) {
            throw new WrongIdException("Wrong user id");
        }
    }

    public void validateUserData(UserDto userDto, String username, String userKey) {
        boolean rightUsername = userDto.getUsername().equals(username);
        boolean rightUserKey = userDto.getUserKey().equals(userKey);
        if (!(rightUserKey && rightUsername)) {
            throw new WrongDataException("Wrong data");
        }
    }

    public void validateUserActive(UserDto userDto) {
        if (!userDto.isStatus()) {
            throw new UserBlockedException("The user is locked");
        }
    }

    public void validateGroupById(Long groupId) {
        if (!groupService.isExist(groupId)) {
            throw new WrongIdException("Wrong group id");
        }
    }

    public void validateCartById(Long cartId) {
        if (!cartService.doesExist(cartId)) {
            throw new WrongDataException("Wrong cart id");
        }
    }

    public void validateItemById(Long itemId) {
        if (!itemService.doesExist(itemId)) {
            throw new WrongDataException("Wrong item id");
        }
    }
}

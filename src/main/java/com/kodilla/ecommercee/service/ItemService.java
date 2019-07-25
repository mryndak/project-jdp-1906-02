package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public boolean doesExist(Long itemId) {
        return itemRepository.existsById(itemId);
    }
}

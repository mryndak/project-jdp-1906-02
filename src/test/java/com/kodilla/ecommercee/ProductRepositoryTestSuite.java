package com.kodilla.ecommercee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void shouldCreateProduct() {
        //Given
        Group group = new Group(1L, "group name", new ArrayList<>());
        Product product = new Product(1L, "name", "test description", new BigDecimal("10.0"), group);

        //When
        productRepository.save(product);
        List<Product> products = productRepository.findAll();

        //Then
        Assert.assertEquals(1, products.size());

    }

    @Test
    public void shouldCreateGroup() {
        //Given
        Group group = new Group(1L, "group name", new ArrayList<>());

        //When
        groupRepository.save(group);
        List<Group> groups = groupRepository.findAll();

        //Then
        Assert.assertEquals(1, groups.size());

    }
}
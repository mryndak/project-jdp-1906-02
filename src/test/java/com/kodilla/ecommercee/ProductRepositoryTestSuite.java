package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.domain.ProductEntity;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldCreateProduct() {
        //Given
        GroupEntity group = new GroupEntity(1L, "group name", new ArrayList<>());
        ProductEntity productEntity = new ProductEntity(1L, "name", "test description", new BigDecimal("10.0"), group);

        //When
        productRepository.save(productEntity);
        Long id = productRepository.findAll().get(0).getId();
        boolean isExist = productRepository.existsById(id);
        List<ProductEntity> productEntities = productRepository.findAll();

        //Then
        Assert.assertTrue(isExist);
        Assert.assertEquals("name", productEntities.get(0).getName());

        //CleanUp
        productRepository.deleteById(id);
    }

    @Test
    public void shouldFindAllProducts() {
        //Given
        GroupEntity group = new GroupEntity(1L, "group name", new ArrayList<>());
        ProductEntity productEntity1 = new ProductEntity(1L, "name", "test description", new BigDecimal("10.0"), group);
        ProductEntity productEntity2 = new ProductEntity(2L, "second name", "test description", new BigDecimal("30.0"), group);
        productRepository.save(productEntity1);
        productRepository.save(productEntity2);
        Long id1 = productRepository.findAll().get(0).getId();
        Long id2 = productRepository.findAll().get(1).getId();

        //When
        List<ProductEntity> productEntities = productRepository.findAll();

        //Then
        Assert.assertEquals(2, productEntities.size());

        //CleanUp
        productRepository.deleteById(id1);
        productRepository.deleteById(id2);
    }

    @Test
    public void shouldFindOneProduct() {
        //Given
        GroupEntity group = new GroupEntity(1L, "group name", new ArrayList<>());
        ProductEntity productEntity = new ProductEntity(1L, "name", "test description", new BigDecimal("10.0"), group);
        productRepository.save(productEntity);
        Long id = productRepository.findAll().get(0).getId();

        //When
        Optional<ProductEntity> productEntities = productRepository.findById(id);

        //Then
        Assert.assertEquals("name", productEntities.get().getName());

        //CleanUp
        productRepository.deleteById(id);
    }

    @Test
    public void shouldUpdateProduct() {
        //Given
        GroupEntity group = new GroupEntity(1L, "group name", new ArrayList<>());
        ProductEntity productEntity1 = new ProductEntity(1L, "name", "test description", new BigDecimal("10.0"), group);
        productRepository.save(productEntity1);
        Long id = productRepository.findAll().get(0).getId();
        ProductEntity productEntity2 = new ProductEntity(id ,"second name", "test description", new BigDecimal("30.0"), group);

        //When
        productRepository.save(productEntity2);
        Optional<ProductEntity> productEntities = productRepository.findById(id);

        //Then
        Assert.assertEquals("second name", productEntities.get().getName());

        //CleanUp
        productRepository.deleteById(id);
    }

    @Test
    public void shouldDeleteProduct() {
        //Given
        GroupEntity group = new GroupEntity(1L, "group name", new ArrayList<>());
        ProductEntity productEntity1 = new ProductEntity(1L, "name", "test description", new BigDecimal("10.0"), group);
        ProductEntity productEntity2 = new ProductEntity(2L, "second name", "test description", new BigDecimal("30.0"), group);
        productRepository.save(productEntity1);
        productRepository.save(productEntity2);
        Long id1 = productRepository.findAll().get(0).getId();
        Long id2 = productRepository.findAll().get(1).getId();

        //When
        productRepository.deleteById(id1);
        List<ProductEntity> productEntities = productRepository.findAll();

        //Then
        Assert.assertEquals(1, productEntities.size());

        //CleanUp
        productRepository.deleteById(id2);
    }

}
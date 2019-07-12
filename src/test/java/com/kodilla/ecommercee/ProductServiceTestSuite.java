package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class ProductServiceTestSuite {

    @Autowired
    private ProductService productService;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void shouldCreateProduct() {
        //When
        GroupEntity groupEntity = new GroupEntity(1L, "group", new ArrayList<>());
        groupRepository.save(groupEntity);
        ProductDto productDto = new ProductDto(1L, "test", "test description", new BigDecimal(100.0), 1L);

        //Then
        productService.saveProduct(productDto);
        List<ProductDto> productDtoList = productService.getAllProducts();
        ProductDto productFromDb = productDtoList.get(productDtoList.size() - 1);
        Long id = productFromDb.getId();

        //Given
        Assert.assertEquals(productDto.getName(), productFromDb.getName());

        //CleanUp
        productService.deleteProduct(id);
    }
}


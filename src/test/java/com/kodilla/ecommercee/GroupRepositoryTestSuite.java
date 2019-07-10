package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupRepositoryTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void shouldCreateGroup(){
        //Given
        GroupEntity group = new GroupEntity(1L, "group name", new ArrayList<>());

        //When
        groupRepository.save(group);
        Long id = groupRepository.findAll().get(0).getId();
        boolean isExist = groupRepository.existsById(id);
        List<GroupEntity> groupEntities = groupRepository.findAll();


        //Then
        Assert.assertTrue(isExist);
        Assert.assertEquals("group name", groupEntities.get(0).getName());
    }
}

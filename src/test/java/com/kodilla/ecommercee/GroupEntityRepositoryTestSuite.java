package com.kodilla.ecommercee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityRepositoryTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void shouldCreateGroup() {
        //Given
        GroupEntity group = new GroupEntity(17L, "group name", new ArrayList<>());
        Long groupId = group.getId();

        //When
        groupRepository.save(group);
        List<GroupEntity> groups = groupRepository.findAll();

        //Then
  //      Assert.assertEquals(1, groups.size());


    }
}

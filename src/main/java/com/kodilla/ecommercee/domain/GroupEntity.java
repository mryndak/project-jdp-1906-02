package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "group_entity")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(
            targetEntity = ProductEntity.class,
            mappedBy = "groupEntity",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ProductEntity> productEntities = new ArrayList<>();

}

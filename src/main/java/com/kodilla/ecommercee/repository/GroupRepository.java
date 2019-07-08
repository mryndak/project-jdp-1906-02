package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> { }

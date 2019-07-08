package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

    @Override
    GroupEntity save(GroupEntity groupEntity);

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    GroupEntity getOne(Long aLong);

    Optional<GroupEntity> getById(Long id);

}
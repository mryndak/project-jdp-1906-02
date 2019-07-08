package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Override
    UserEntity save(UserEntity userEntity);
}

package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    @Override
    LoginEntity save(LoginEntity loginEntity);

}

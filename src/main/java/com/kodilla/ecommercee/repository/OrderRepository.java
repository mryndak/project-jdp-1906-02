package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Override
    OrderEntity save(OrderEntity orderEntity);

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    OrderEntity getOne(Long aLong);

    Optional<OrderEntity> getById(Long id);
}

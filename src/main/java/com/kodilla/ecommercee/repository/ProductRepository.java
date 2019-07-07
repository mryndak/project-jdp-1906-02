package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Override
    ProductEntity save(ProductEntity productEntity);

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    ProductEntity getOne(Long aLong);

    Optional<ProductEntity> getById(Long id);


}

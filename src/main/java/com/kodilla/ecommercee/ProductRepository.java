package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Override
    ProductEntity save(ProductEntity product);

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    ProductEntity getOne(Long aLong);

    Optional<Product> getById(Long id);


}

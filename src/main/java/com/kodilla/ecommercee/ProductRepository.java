package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save(Product product);

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    Product getOne(Long aLong);

    Optional<Product> getById(Long id);


}

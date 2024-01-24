package com.personal.RedisCache.repositories;

import com.personal.RedisCache.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Optional<Product> findByProductName(String name);
    public Optional<Product> findByProductCode(String code);
}

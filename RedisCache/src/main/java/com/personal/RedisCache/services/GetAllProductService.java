package com.personal.RedisCache.services;

import com.personal.RedisCache.models.Product;
import com.personal.RedisCache.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GetAllProductService {

    private final ProductRepository productRepository;
    public GetAllProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(cacheNames = "products", key = "#name")
    public List<Product> getProduct(String name){
        return productRepository.findAll();
    }
}

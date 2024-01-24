package com.personal.RedisCache.services;

import com.personal.RedisCache.models.Product;
import com.personal.RedisCache.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class GetProductService {

    private final ProductRepository productRepository;
    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(cacheNames = "products", key = "#name")
    public Product getProduct(String name){
        log.info("Db called");
        Optional<Product> obj = productRepository.findByProductName(name);
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }
}

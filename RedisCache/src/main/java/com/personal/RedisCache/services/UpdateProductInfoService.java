package com.personal.RedisCache.services;

import com.personal.RedisCache.models.Product;
import com.personal.RedisCache.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UpdateProductInfoService {

    private final ProductRepository productRepository;
    public UpdateProductInfoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CacheEvict(cacheNames = "products", key = "#name")
    public String updateProduct(String productCode, Integer price){
        log.info("Db called");
        Optional<Product> obj = productRepository.findByProductCode(productCode);
        if(obj.isPresent()){
            Product product = obj.get();
            product.setPrice(price);
            productRepository.save(product);
            return "Successfully update";
        }
        return "product not found";
    }

}

package com.personal.RedisCache.services;

import com.personal.RedisCache.models.Product;
import com.personal.RedisCache.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class AddProductService {

    private final ProductRepository productRepository;

    public AddProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(Product product){
        productRepository.save(product);
        return "successfully saved";
    }
}

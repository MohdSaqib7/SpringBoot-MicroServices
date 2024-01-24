package com.personal.RedisCache.services;

import com.personal.RedisCache.models.Product;
import com.personal.RedisCache.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DeleteProductService {

    private final ProductRepository productRepository;
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String deleteProduct(String productCode){
        Optional<Product> obj = productRepository.findByProductCode(productCode);
        if(obj.isPresent()){
            Product product = obj.get();
            productRepository.delete(product);
            return "Successfully Delete : "+product.getProductName();
        }
        return "Product Not found";
    }

}

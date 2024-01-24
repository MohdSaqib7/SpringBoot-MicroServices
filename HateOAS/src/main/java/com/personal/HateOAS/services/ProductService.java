package com.personal.HateOAS.services;

import com.personal.HateOAS.models.Product;
import com.personal.HateOAS.repositories.ProductRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Collection<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    public Optional<Product> findByProductName(String productName){
        return productRepository.findByProductName(productName);
    }
    public String addProduct(Product product){
        productRepository.save(product);
        return "successfully added";
    }
}

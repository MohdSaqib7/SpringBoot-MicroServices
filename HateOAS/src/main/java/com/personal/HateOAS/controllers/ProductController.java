package com.personal.HateOAS.controllers;

import com.personal.HateOAS.models.Product;
import com.personal.HateOAS.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/productApi")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProducts")
    public Collection<Product> findAllProduct(){
        Collection<Product> productsArr = productService.findAll();
        List<Product> productList = new ArrayList<>();
        List<Product> products = productsArr.stream().toList();
        products.forEach(p -> {
            p.add(linkTo(methodOn(ProductController.class).findById(p.getId())).withSelfRel());
            p.add(linkTo(methodOn(ProductController.class).findByProductName(p.getProductName())).withSelfRel());
            productList.add(p);
        });
        return productList;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Integer id){
        Product product;
        Optional<Product> productDetails = productService.findById(id);

        if(!productDetails.isPresent()){
            product = null;
        }else{
            product = productDetails.get();
            product.add(linkTo(methodOn(ProductController.class).findAllProduct()).withSelfRel());
        }
        return product;
    }

    @GetMapping("/{productName}")
    public Product findByProductName(@PathVariable("productName") String productName){

        Product product = null;
        Optional<Product> productDetails = productService.findByProductName(productName);
        if(!productDetails.isPresent()){
            product = null;
        }else{
            product = productDetails.get();
            product.add(linkTo(methodOn(ProductController.class).findAllProduct()).withSelfRel());
        }
        return product;
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}

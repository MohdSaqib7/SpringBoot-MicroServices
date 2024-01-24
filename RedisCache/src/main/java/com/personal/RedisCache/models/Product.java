package com.personal.RedisCache.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@Entity()
@Table(name="products")
public class Product implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_code")
    private String productCode;

    @Column
    private Integer price;
}

package com.personal.HateOAS.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="product_table")
@Data
public class Product extends RepresentationModel<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Integer id;

    @Column(name="product_name")
    private String productName;

    @Column(name="price")
    private Integer price;

    @Column(name="expire_date")
    private String expireDate;
}

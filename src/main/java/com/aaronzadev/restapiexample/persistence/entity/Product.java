package com.aaronzadev.restapiexample.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "products")
public class Product {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTID")
    private Long productId;
    @Column(name = "PRODUCTNAME")
    private String productName;
    @Column(name = "PRODUCTDESCRIPTION")
    private String productDescription;
    @Column(name = "PRODUCTPRICE")
    private float productPrice;
    @Column(name = "DISCONTINUED")
    private boolean discontinued;

}

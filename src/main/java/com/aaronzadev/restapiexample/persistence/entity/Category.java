package com.aaronzadev.restapiexample.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORYID")
    private Long categoryId;
    @Column(name = "CATEGORYNAME")
    private String categoryName;
    @Column(name = "CATEGORYDESCRIPTION")
    private String categoryDescription;

}

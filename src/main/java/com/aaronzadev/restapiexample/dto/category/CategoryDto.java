package com.aaronzadev.restapiexample.dto.category;


import lombok.Data;

@Data
public class CategoryDto {

    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

}

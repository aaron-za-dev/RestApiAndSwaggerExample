package com.aaronzadev.restapiexample.dto.product;

import lombok.Data;

@Data
public class ProductDto {

    private Long productId;
    private String productName;
    private String productDescription;
    private float productPrice;
    private boolean discontinued;
    private String productCategory;

}

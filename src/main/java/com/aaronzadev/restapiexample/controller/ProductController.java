package com.aaronzadev.restapiexample.controller;

import com.aaronzadev.restapiexample.persistence.entity.Product;
import com.aaronzadev.restapiexample.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO change to BASE_URL prop
@RequestMapping("/api/v1")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public Page<Product> allProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize){
        return productService.getProductsPage(page, pageSize);
    }



}

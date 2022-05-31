package com.aaronzadev.restapiexample.controller;

import com.aaronzadev.restapiexample.dto.ProductDto;
import com.aaronzadev.restapiexample.persistence.entity.Product;
import com.aaronzadev.restapiexample.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
//TODO change to BASE_URL prop
@RequestMapping("/api/v1")
public class ProductController {

    /*private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }*/

    private final IGenericService<Product, ProductDto> productService;

    public ProductController(IGenericService<Product, ProductDto> productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public Page<Product> allProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize){
        //return productService.getProductsPage(page, pageSize);
        return productService.getAllItems(page, pageSize);
    }

    @PostMapping(value = "/products")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveItem(product);
    }

}

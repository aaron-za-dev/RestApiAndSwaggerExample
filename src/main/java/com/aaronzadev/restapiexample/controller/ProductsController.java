package com.aaronzadev.restapiexample.controller;

import com.aaronzadev.restapiexample.dto.ProductDto;
import com.aaronzadev.restapiexample.persistence.entity.Product;
import com.aaronzadev.restapiexample.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
//TODO change to BASE_URL prop
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final IGenericService<ProductDto> productService;

    public ProductsController(IGenericService<ProductDto> productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/")
    public Page<ProductDto> showPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize){
        return productService.getAllItems(page, pageSize);
    }

    @GetMapping(value = "/{productId}")
    public ProductDto show(@PathVariable Long productId){
        return productService.getItemById(productId);
    }

    @PostMapping(value = "/")
    public ProductDto save(@RequestBody ProductDto productDto){
        return productService.saveItem(productDto);
    }

    @PatchMapping(value = "/{productId}")
    public ProductDto patch(@PathVariable Long productId, @RequestBody ProductDto productDto){
        return productService.updateItemPartial(productId, productDto);
    }

    @PutMapping(value = "/{productId}")
    public ProductDto put(@PathVariable Long productId, @RequestBody ProductDto productDto){
        return productService.updateItem(productId, productDto);
    }

    @DeleteMapping(value = "/{productId}")
    public void delete(@PathVariable Long productId){
        productService.deleteItem(productId);
    }

}

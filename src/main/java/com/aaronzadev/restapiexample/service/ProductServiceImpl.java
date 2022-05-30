package com.aaronzadev.restapiexample.service;

import com.aaronzadev.restapiexample.persistence.entity.Product;
import com.aaronzadev.restapiexample.persistence.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    private final IProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    //TODO change type Product to ProductDto
    @Override
    public Page<Product> getProductsPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepo.findAll(pageable);
    }
}

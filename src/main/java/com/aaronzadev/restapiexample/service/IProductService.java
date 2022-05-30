package com.aaronzadev.restapiexample.service;

import com.aaronzadev.restapiexample.persistence.entity.Product;
import org.springframework.data.domain.Page;

public interface IProductService {

    Page<Product> getProductsPage(int page, int pageSize);

}

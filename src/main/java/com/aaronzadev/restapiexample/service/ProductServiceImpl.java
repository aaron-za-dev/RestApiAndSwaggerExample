package com.aaronzadev.restapiexample.service;

import com.aaronzadev.restapiexample.dto.ProductDto;
import com.aaronzadev.restapiexample.persistence.entity.Product;
import com.aaronzadev.restapiexample.persistence.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IGenericService<Product, ProductDto>{

    private final IProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Page<Product> getAllItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepo.findAll(pageable);
    }

    @Override
    public Product getSingleItem(Long entityId) {
        return productRepo.findById(entityId).orElse(new Product());
    }

    @Override
    public Product saveItem(Product entity) {
        return productRepo.save(entity);
    }

    @Override
    public Product updateItem(Product entity) {
        return productRepo.save(entity);
    }

    @Override
    public void deleteItem(Long itemId) {
        Product product = getSingleItem(itemId);
        productRepo.delete(product);
    }

    @Override
    public ProductDto mapEntityToDto(Product entity) {
        return null;
    }

    @Override
    public Product mapDtoToEntity(ProductDto dto) {
        return null;
    }



    /*private final IProductRepo productRepo;

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

    @Override
    public Product getProductById(Long productId) {
        return productRepo.findById(productId).map(product -> {});
    }*/
}

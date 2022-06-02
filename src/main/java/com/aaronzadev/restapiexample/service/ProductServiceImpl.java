package com.aaronzadev.restapiexample.service;

import com.aaronzadev.restapiexample.dto.ProductDto;
import com.aaronzadev.restapiexample.persistence.entity.Product;
import com.aaronzadev.restapiexample.persistence.repository.IProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IGenericService<ProductDto, Product>{

    private final IProductRepo productRepo;
    private final ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(IProductRepo productRepo, ModelMapper mapper) {
        this.productRepo = productRepo;
        this.mapper = mapper;
    }

    @Override
    public Page<ProductDto> getAllItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepo.findAll(pageable).map(this::mapEntityToDto);
    }


    @Override
    public ProductDto getItemById(Long itemId) {
        return productRepo.findById(itemId).map(this::mapEntityToDto).orElse(new ProductDto());
    }

    @Override
    public ProductDto saveItem(ProductDto productDto) {
        Product product = mapDtoToEntity(productDto);
        return mapEntityToDto(productRepo.save(product));
    }

    @Override
    public ProductDto updateItemPartial(Long itemId, ProductDto productDto) {
        //TODO change implementation check if items exists before update
        Product product = mapDtoToEntity(productDto);
        return mapEntityToDto(productRepo.save(product));
    }

    @Override
    public ProductDto updateItem(Long itemId, ProductDto productDto) {
        //TODO change implementation check if items exists before update
        Product product = mapDtoToEntity(productDto);
        return mapEntityToDto(productRepo.save(product));
    }

    @Override
    public void deleteItem(Long itemId) {
        Product product = productRepo.findById(itemId).orElse(new Product());
        productRepo.delete(product);
        /*if(productRepo.findById(itemId).isPresent()){
            productRepo.deleteById(itemId);
        }*/
    }

    @Override
    public ProductDto mapEntityToDto(Product productEntity) {
        return mapper.map(productEntity, ProductDto.class);
    }

    @Override
    public Product mapDtoToEntity(ProductDto productDto) {
        return mapper.map(productDto, Product.class);
    }


}

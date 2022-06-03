package com.aaronzadev.restapiexample.service;

import com.aaronzadev.restapiexample.dto.ProductDto;
import com.aaronzadev.restapiexample.mappers.IProductMapper;
import com.aaronzadev.restapiexample.persistence.entity.Product;
import com.aaronzadev.restapiexample.persistence.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IGenericService<ProductDto>{

    private final IProductRepo productRepo;
    private final IProductMapper productMapper = IProductMapper.INSTANCE;
    //private final ModelMapper mapper;

    /*@Autowired
    public ProductServiceImpl(IProductRepo productRepo, ModelMapper mapper) {
        this.productRepo = productRepo;
        this.mapper = mapper;
    }*/

    @Autowired
    public ProductServiceImpl(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public Page<ProductDto> getAllItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepo.findAll(pageable).map(productMapper::productEntityToDto);
    }


    @Override
    public ProductDto getItemById(Long itemId) {
        return productRepo.findById(itemId).map(productMapper::productEntityToDto).orElse(new ProductDto());
    }

    @Override
    public ProductDto saveItem(ProductDto productDto) {
        Product product = productMapper.productDtoToEntity(productDto);
        return productMapper.productEntityToDto(productRepo.save(product));
    }

    @Override
    public ProductDto updateItemPartial(Long itemId, ProductDto productDto) {
        //TODO change implementation check if items exists before update
        Product product = productMapper.productDtoToEntity(productDto);
        return productMapper.productEntityToDto(productRepo.save(product));
    }

    @Override
    public ProductDto updateItem(Long itemId, ProductDto productDto) {
        //TODO change implementation check if items exists before update
        Product product = productMapper.productDtoToEntity(productDto);
        return productMapper.productEntityToDto(productRepo.save(product));
    }

    @Override
    public void deleteItem(Long itemId) {
        //TODO check if exists before delete
        Product product = productRepo.findById(itemId).orElse(new Product());
        productRepo.delete(product);
        /*if(productRepo.findById(itemId).isPresent()){
            productRepo.deleteById(itemId);
        }*/
    }


}

package com.aaronzadev.restapiexample.mappers;

import com.aaronzadev.restapiexample.dto.product.ProductDto;
import com.aaronzadev.restapiexample.persistence.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);


    @Mappings({
       @Mapping(target = "productCategory", source = "category.categoryName")
    })
    ProductDto productEntityToDto(Product product);

    @Mappings({
       @Mapping(target = "productId", ignore = true),
       @Mapping(target = "discontinued", ignore = true),
       @Mapping(target = "category", ignore = true)
    })
    Product productDtoToEntity(ProductDto productDto);


}

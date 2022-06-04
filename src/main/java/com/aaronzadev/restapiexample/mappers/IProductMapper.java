package com.aaronzadev.restapiexample.mappers;

import com.aaronzadev.restapiexample.dto.product.ProductDto;
import com.aaronzadev.restapiexample.persistence.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    /*@Mapping(source = "productId", target = "productId")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "productDescription", target = "productDescription")
    @Mapping(source = "productPrice", target = "productPrice")
    @Mapping(source = "discontinued", target = "discontinued")*/
    //@Mapping(source = "category.category", target = "productCategory")
    ProductDto productEntityToDto(Product product);

    @Mapping(target = "productId", ignore = true)
    //@Mapping(target = "discontinued", ignore = true)
    Product productDtoToEntity(ProductDto productDto);


}

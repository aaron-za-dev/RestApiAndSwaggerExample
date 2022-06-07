package com.aaronzadev.restapiexample.mappers;

import com.aaronzadev.restapiexample.dto.category.CategoryDto;
import com.aaronzadev.restapiexample.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ICategoryMapper {

    ICategoryMapper categoryMapper = Mappers.getMapper(ICategoryMapper.class);

    @Mapping(target = "categoryId", ignore = true)
    CategoryDto categoryEntityToDto(Category category);

    //@Mapping()
    Category categoryDtoToEntity(CategoryDto categoryDto);

}

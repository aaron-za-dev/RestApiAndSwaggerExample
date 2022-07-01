package com.aaronzadev.restapiexample.mappers.page;

import com.aaronzadev.restapiexample.persistence.dto.page.PageOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface IPageMapper {

    @Mapping(target = "items", expression = "java(page.getContent())")
    @Mapping(target = "firstPage", source = "first")
    @Mapping(target = "lastPage", source = "last")
    @Mapping(target = "prevPage", expression = "java(page.isFirst() ? null : page.getNumber() )")
    @Mapping(target = "currentPage", expression = "java(page.getNumber() + 1)")
    @Mapping(target = "nextPage", expression = "java(page.isLast() ? null : page.getNumber() + 2 )")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalItems", source = "totalElements")
    PageOutDto mapToPageOutDto(Page<?> page);

}

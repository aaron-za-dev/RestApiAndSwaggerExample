package com.aaronzadev.restapiexample.mappers.city;

import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ICityMapper {

    @Mapping(target = "cityId", ignore = true)
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(java.sql.Timestamp.from(java.time.Instant.now()))")
    CityEntity mapToEntity(CityInDto cityInDto);

    @Mapping(target = "cityId", ignore = true)
    @Mapping(target = "cityName", source = "cityInDto.cityName")
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(java.sql.Timestamp.from(java.time.Instant.now()))")
    CityEntity mapToEntity(Long id, CityInDto cityInDto);

    //@Mapping(target = "lastUpdate", expression = "java(cityEntity.getLastUpdate().toString())")
    @Mapping(target = "lastUpdate", expression = "java(cityEntity.getLastUpdate())")
    CityOutDto mapToOutDto(CityEntity cityEntity);

    @Mapping(target = "items", expression = "java(page.getContent())")
    @Mapping(target = "firstPage", source = "first")
    @Mapping(target = "lastPage", source = "last")
    @Mapping(target = "prevPage", expression = "java(page.isFirst() ? null : page.getNumber() )")
    @Mapping(target = "currentPage", expression = "java(page.getNumber() + 1)")
    @Mapping(target = "nextPage", expression = "java(page.isLast() ? null : page.getNumber() + 2 )")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalItems", source = "totalElements")
    PageOutDto mapToPageOutDto(Page<CityOutDto> page);


}

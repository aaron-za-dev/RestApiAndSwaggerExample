package com.aaronzadev.restapiexample.mappers.country;

import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ICountryMapper {

    @Mapping(target = "countryId", ignore = true)
    @Mapping(target = "countryName", source = "countryName")
    @Mapping(target = "cities", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(java.sql.Timestamp.from(java.time.Instant.now()))")
    CountryEntity mapToEntity(CountryInDto countryInDto);

    @Mapping(target = "countryId", source = "id")
    @Mapping(target = "countryName", source = "countryInDto.countryName")
    @Mapping(target = "cities", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(java.sql.Timestamp.from(java.time.Instant.now()))")
    CountryEntity mapToEntity(Long id, CountryInDto countryInDto);

    @Mapping(target = "lastUpdate", expression = "java(countryEntity.getLastUpdate().toString())")
    CountryOutDto mapToOutDto(CountryEntity countryEntity);

    @Mapping(target = "items", expression = "java(page.getContent())")
    @Mapping(target = "firstPage", source = "first")
    @Mapping(target = "lastPage", source = "last")
    @Mapping(target = "prevPage", expression = "java(page.isFirst() ? null : page.getNumber() )")
    @Mapping(target = "currentPage", expression = "java(page.getNumber() + 1)")
    @Mapping(target = "nextPage", expression = "java(page.isLast() ? null : page.getNumber() + 2 )")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalItems", source = "totalElements")
    PageOutDto mapToPageOutDto(Page<CountryOutDto> page);

}

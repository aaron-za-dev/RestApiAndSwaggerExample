package com.aaronzadev.restapiexample.mappers.country;

import com.aaronzadev.restapiexample.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICountryMapper {

    @Mapping(target = "countryId", ignore = true)
    @Mapping(target = "countryName", source = "countryName")
    @Mapping(target = "cities", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(new java.sql.Timestamp(new java.util.Date().getTime()))")
    CountryEntity mapToEntity(CountryInDto countryInDto);

    CountryOutDto mapToOutDto(CountryEntity countryEntity);

}

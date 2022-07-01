package com.aaronzadev.restapiexample.mappers.country;

import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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

}

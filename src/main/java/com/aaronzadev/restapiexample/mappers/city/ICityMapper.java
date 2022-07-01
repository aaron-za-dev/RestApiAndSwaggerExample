package com.aaronzadev.restapiexample.mappers.city;

import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICityMapper {

    @Mapping(target = "cityId", ignore = true)
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(java.sql.Timestamp.from(java.time.Instant.now()))")
    CityEntity mapToEntity(CityInDto cityInDto);

    @Mapping(target = "cityId", source = "id")
    @Mapping(target = "cityName", source = "cityInDto.cityName")
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "lastUpdate", expression = "java(java.sql.Timestamp.from(java.time.Instant.now()))")
    CityEntity mapToEntity(Long id, CityInDto cityInDto);

    //@Mapping(target = "lastUpdate", expression = "java(cityEntity.getLastUpdate().toString())")
    @Mapping(target = "lastUpdate", expression = "java(cityEntity.getLastUpdate())")
    CityOutDto mapToOutDto(CityEntity cityEntity);


}

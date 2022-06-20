package com.aaronzadev.restapiexample.mappers.city;

import com.aaronzadev.restapiexample.persistence.dto.city.CityDto;
import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import org.mapstruct.*;


//TODO TO TEST
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {

    CityEntity cityDtoToCityEntity(CityDto cityDto);

    CityDto cityEntityToCityDto(CityEntity cityEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCityEntityFromCityDto(CityDto cityDto, @MappingTarget CityEntity cityEntity);
}

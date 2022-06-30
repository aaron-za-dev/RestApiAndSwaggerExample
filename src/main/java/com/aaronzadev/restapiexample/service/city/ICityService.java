package com.aaronzadev.restapiexample.service.city;

import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.service.IBaseService;

public interface ICityService extends IBaseService<CityOutDto, CityInDto> {
}
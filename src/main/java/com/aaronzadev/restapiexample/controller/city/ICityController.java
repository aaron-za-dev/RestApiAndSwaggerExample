package com.aaronzadev.restapiexample.controller.city;

import com.aaronzadev.restapiexample.controller.IBaseController;
import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CityEntity;

public interface ICityController extends IBaseController<CityOutDto, CityInDto> {


}
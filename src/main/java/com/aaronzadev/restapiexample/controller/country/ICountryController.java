package com.aaronzadev.restapiexample.controller.country;

import com.aaronzadev.restapiexample.controller.IBaseController;
import com.aaronzadev.restapiexample.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;

public interface ICountryController extends IBaseController<CountryOutDto, CountryInDto> {

}

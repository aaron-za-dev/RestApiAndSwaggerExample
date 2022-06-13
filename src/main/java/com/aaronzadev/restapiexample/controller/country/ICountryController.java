package com.aaronzadev.restapiexample.controller.country;

import com.aaronzadev.restapiexample.controller.IBaseController;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;

public interface ICountryController extends IBaseController<CountryOutDto, CountryInDto> {

}

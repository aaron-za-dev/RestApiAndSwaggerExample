package com.aaronzadev.restapiexample.service.country;

import com.aaronzadev.restapiexample.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.service.IBaseService;

public interface ICountryService extends IBaseService<CountryOutDto, CountryInDto> {
}

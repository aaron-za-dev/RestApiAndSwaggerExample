package com.aaronzadev.restapiexample.service.country;

import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;
import com.aaronzadev.restapiexample.service.IBaseService;

public interface ICountryService extends IBaseService<CountryOutDto, CountryInDto> {

    PageOutDto getPagedCountries(int page, int pageSize, String orderField, String orderDirection);

}

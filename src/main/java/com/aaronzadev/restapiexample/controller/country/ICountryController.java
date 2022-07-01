package com.aaronzadev.restapiexample.controller.country;

import com.aaronzadev.restapiexample.controller.IBaseController;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.dto.page.PageOutDto;
import org.springframework.http.ResponseEntity;

public interface ICountryController extends IBaseController<CountryOutDto, CountryInDto> {

    ResponseEntity<PageOutDto> getPagedCountries(int page, int pageSize, String sortingField, String sortingDirection);
}

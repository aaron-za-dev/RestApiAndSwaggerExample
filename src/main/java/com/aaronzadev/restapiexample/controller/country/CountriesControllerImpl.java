package com.aaronzadev.restapiexample.controller.country;

import com.aaronzadev.restapiexample.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import com.aaronzadev.restapiexample.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/countries")
public class CountriesControllerImpl implements ICountryController {

    private final ICountryService countryService;

    @Autowired
    public CountriesControllerImpl(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @GetMapping(value = "/")
    public Page<CountryOutDto> getPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return countryService.getAllItems(page, pageSize);
    }

    @Override
    @GetMapping(value = "/{countryId}")
    public CountryOutDto getById(@PathVariable Long countryId) {
        return countryService.getItemById(countryId);
    }

    @Override
    @PostMapping(value = "/")
    public CountryOutDto saveItem(@Valid @RequestBody CountryInDto countryInDto) {
        return countryService.saveItem(countryInDto);
    }

    @Override
    @PatchMapping(value = "/{countryId}")
    public CountryOutDto partialUpdate(@PathVariable Long countryId, @RequestBody CountryInDto countryInDto) {
        return countryService.updateItemPartial(countryId, countryInDto);
    }

    @Override
    @PutMapping(value = "/{countryId}")
    public CountryOutDto completeUpdate(@PathVariable Long countryId, @RequestBody CountryInDto countryInDto) {
        return countryService.updateItem(countryId, countryInDto);
    }

    @Override
    @DeleteMapping(value = "/{countryId}")
    public void deleteItem(@PathVariable Long countryId) {
        countryService.deleteItem(countryId);
    }

}

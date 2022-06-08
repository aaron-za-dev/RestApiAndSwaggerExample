package com.aaronzadev.restapiexample.controller.country;

import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import com.aaronzadev.restapiexample.service.country.ICountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/countries")
public class CountriesControllerImpl implements ICountriesController{

    private final Logger LOGGER =LoggerFactory.getLogger(ICountriesController.class);

    private final ICountryService countryService;

    @Autowired
    public CountriesControllerImpl(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @GetMapping(value = "/")
    public Page<CountryEntity> getPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return countryService.getAllItems(page, pageSize);
    }

    @Override
    @GetMapping(value = "/{countryId}")
    public CountryEntity getById(@PathVariable Long countryId) {
        return countryService.getItemById(countryId);
    }

    @Override
    @PostMapping(value = "/")
    public CountryEntity saveItem(CountryEntity country) {
        return countryService.saveItem(country);
    }

    @Override
    @PatchMapping(value = "/{countryId}")
    public CountryEntity partialUpdate(Long countryId, CountryEntity country) {
        return countryService.updateItemPartial(countryId, country);
    }

    @Override
    @PutMapping(value = "/{countryId}")
    public CountryEntity completeUpdate(Long countryId, CountryEntity country) {
        return countryService.updateItem(countryId, country);
    }

    @Override
    @DeleteMapping(value = "/{countryId}")
    public void deleteItem(Long countryId) {
        countryService.deleteItem(countryId);
    }

}

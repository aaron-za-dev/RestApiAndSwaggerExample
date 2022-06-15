package com.aaronzadev.restapiexample.controller.country;

import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

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
    public ResponseEntity<Page<CountryOutDto>> getPagedItems(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(countryService.getPagedItems(page, pageSize));
    }

    @Override
    @GetMapping(value = "/{countryId}")
    public ResponseEntity<CountryOutDto> getItemById(@PathVariable Long countryId) {
        return ResponseEntity.ok(countryService.getItemById(countryId));
    }

    @Override
    @PostMapping(value = "/")
    public ResponseEntity<CountryOutDto> saveItem(@Valid @RequestBody CountryInDto countryInDto) {
        final CountryOutDto countrySaved =  countryService.saveItem(countryInDto);
        return ResponseEntity.created(URI.create("/api/v1/countries/"+countrySaved.countryId())).body(countrySaved);
    }

    @Override
    @PatchMapping(value = "/{countryId}")
    public ResponseEntity<CountryOutDto> updateItemPartially(@PathVariable Long countryId, @RequestBody CountryInDto countryInDto) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    @PutMapping(value = "/{countryId}")
    public ResponseEntity<CountryOutDto> updateItem(@PathVariable Long countryId, @RequestBody CountryInDto countryInDto) {
        return ResponseEntity.ok(countryService.updateItem(countryId, countryInDto));
    }

    @Override
    @DeleteMapping(value = "/{countryId}") //TODO Can be implement softDelete
    public void deleteItem(@PathVariable Long countryId) {
        countryService.deleteItem(countryId);
    }

}

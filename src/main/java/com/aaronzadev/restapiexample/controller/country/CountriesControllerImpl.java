package com.aaronzadev.restapiexample.controller.country;

import com.aaronzadev.restapiexample.persistence.dto.page.PageOutDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.service.country.ICountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/countries")
@Tag(name = "CountryController", description = "All endpoints of 'country' resource")
public class CountriesControllerImpl implements ICountryController {

    private final ICountryService countryService;

    @Autowired
    public CountriesControllerImpl(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @Operation(summary = "Get all countries paged")
    @ApiResponses(value = {})
    @GetMapping(value = "/")
    public ResponseEntity<PageOutDto> getPagedItems(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(countryService.getPagedItems(page, pageSize));
    }

    @Override
    @Operation(summary = "Get all items paged, filtered and sorted")
    @ApiResponses(value = {})
    @GetMapping(value = "/sort/")
    public ResponseEntity<PageOutDto> getPagedCountries(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "countryId") String sortingField, @RequestParam(defaultValue = "DESC") String sortingDirection) {
        return ResponseEntity.ok(countryService.getPagedCountries(page, pageSize, sortingField, sortingDirection));
    }

    @Override
    @Operation(summary = "Get country by ID")
    @ApiResponses(value = {})
    @GetMapping(value = "/{countryId}")
    public ResponseEntity<CountryOutDto> getItemById(@PathVariable Long countryId) {
        return ResponseEntity.ok(countryService.getItemById(countryId));
    }

    @Override
    @Operation(summary = "Save one country")
    @ApiResponses(value = {})
    @PostMapping(value = "/")
    public ResponseEntity<CountryOutDto> saveItem(@Valid @RequestBody CountryInDto countryInDto) {
        final CountryOutDto countrySaved =  countryService.saveItem(countryInDto);
        return ResponseEntity.created(URI.create("/api/v1/countries/"+countrySaved.countryId())).body(countrySaved);
    }

    @Override
    @Operation(summary = "Partially update a country")
    @ApiResponses(value = {})
    @PatchMapping(value = "/{countryId}")
    public ResponseEntity<CountryOutDto> updateItemPartially(@PathVariable Long countryId, @Valid @RequestBody CountryInDto countryInDto) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    @Operation(summary = "Update a country")
    @ApiResponses(value = {})
    @PutMapping(value = "/{countryId}")
    public ResponseEntity<CountryOutDto> updateItem(@PathVariable Long countryId, @Valid @RequestBody CountryInDto countryInDto) {
        return ResponseEntity.ok(countryService.updateItem(countryId, countryInDto));
    }

    @Override
    @Operation(summary = "Delete a country given ID")
    @ApiResponses(value = {})
    @DeleteMapping(value = "/{countryId}") //TODO Can be implement softDelete
    public void deleteItem(@PathVariable Long countryId) {
        countryService.deleteItem(countryId);
    }

}

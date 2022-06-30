package com.aaronzadev.restapiexample.controller.city;

import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.service.city.ICityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/cities")
@Tag(name = "CityController", description = "All endpoints of 'city' resource")
public class CityControllerImpl implements ICityController{

    private final ICityService cityService;
    @Autowired
    public CityControllerImpl(ICityService cityService) {
        this.cityService = cityService;
    }

    @Override
    @Operation(summary = "Get all cities paged")
    @ApiResponses(value = {})
    @GetMapping(value = "/")
    public ResponseEntity<PageOutDto> getPagedItems(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(cityService.getPagedItems(page, pageSize));
    }

    @Override
    @Operation(summary = "Get city by ID")
    @ApiResponses(value = {})
    @GetMapping(value = "/{countryId}")
    public ResponseEntity<CityOutDto> getItemById(Long itemId) {
        return ResponseEntity.ok(cityService.getItemById(itemId));
    }

    @Override
    @Operation(summary = "Save one city")
    @ApiResponses(value = {})
    @PostMapping(value = "/")
    public ResponseEntity<CityOutDto> saveItem(@RequestBody CityInDto item) {
        final CityOutDto citySaved = cityService.saveItem(item);
        return ResponseEntity.created(URI.create("/api/v1/cities/"+citySaved.cityId())).body(citySaved);
    }

    @Override
    @Operation(summary = "Partially update a city")
    @ApiResponses(value = {})
    @PatchMapping(value = "/{cityId}")
    public ResponseEntity<CityOutDto> updateItemPartially(Long itemId, CityInDto item) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    @Operation(summary = "Update a city")
    @ApiResponses(value = {})
    @PutMapping(value = "/{cityId}")
    public ResponseEntity<CityOutDto> updateItem(Long itemId, CityInDto item) {
        return ResponseEntity.ok(cityService.updateItem(itemId, item));
    }

    @Override
    @Operation(summary = "Delete a city given ID")
    @ApiResponses(value = {})
    @DeleteMapping(value = "/{cityId}")
    public void deleteItem(Long itemId) {
        cityService.deleteItem(itemId);
    }

}

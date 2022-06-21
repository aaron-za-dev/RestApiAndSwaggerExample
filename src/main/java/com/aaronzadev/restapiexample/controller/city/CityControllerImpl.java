package com.aaronzadev.restapiexample.controller.city;

import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import com.aaronzadev.restapiexample.service.city.CityServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/cities")
@Tag(name = "CityController", description = "All endpoints of 'city' resource")
public class CityControllerImpl implements ICityController{

    private final CityServiceImpl cityService;
    @Autowired
    public CityControllerImpl(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Override
    @Operation(summary = "Get all items paged")
    @ApiResponses(value = {})
    @GetMapping(value = "/")
    public ResponseEntity<PageOutDto> getPagedItems(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(cityService.getPagedItems(page, pageSize));
    }

    @Override
    public ResponseEntity<CityOutDto> getItemById(Long itemId) {
        return null;
    }

    @Override
    public ResponseEntity<CityOutDto> saveItem(CityInDto item) {
        return null;
    }

    @Override
    public ResponseEntity<CityOutDto> updateItemPartially(Long itemId, CityInDto item) {
        return null;
    }

    @Override
    public ResponseEntity<CityOutDto> updateItem(Long itemId, CityInDto item) {
        return null;
    }

    @Override
    public void deleteItem(Long itemId) {

    }

    /*private final CityServiceImpl cityService;

    @Autowired
    public CityControllerImpl(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Override
    @GetMapping(value = "/")
    public Page<CityEntity> getPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return cityService.getAllItems(page, pageSize);
    }

    @Override
    @GetMapping(value = "/{cityId}")
    public CityEntity getById(@PathVariable Long cityId) {
        return cityService.getItemById(cityId);
    }

    @Override
    @PostMapping(value = "/")
    public CityEntity saveItem(@RequestBody CityEntity city) {
        return cityService.saveItem(city);
    }

    @Override
    @PatchMapping(value = "/{cityId}")
    public CityEntity partialUpdate(@PathVariable Long cityId, @RequestBody CityEntity city) {
        return cityService.saveItem(city);
    }

    @Override
    @PutMapping(value = "/{cityId}")
    public CityEntity completeUpdate(@PathVariable Long cityId, @RequestBody CityEntity city) {
        return cityService.saveItem(city);
    }

    @Override
    @DeleteMapping(value = "/{cityId}")
    public void deleteItem(@PathVariable Long cityId) {
        cityService.deleteItem(cityId);
    }*/
}

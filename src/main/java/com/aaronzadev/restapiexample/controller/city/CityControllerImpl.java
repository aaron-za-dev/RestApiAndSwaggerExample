package com.aaronzadev.restapiexample.controller.city;

import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import com.aaronzadev.restapiexample.service.city.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/cities")
public class CityControllerImpl implements ICityController{

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

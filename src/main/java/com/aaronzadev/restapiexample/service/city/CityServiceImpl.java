package com.aaronzadev.restapiexample.service.city;

import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import com.aaronzadev.restapiexample.persistence.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService {

    private final ICityRepo cityRepo;

    @Autowired
    public CityServiceImpl(ICityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public PageOutDto getPagedItems(int page, int pageSize) {
        return null;
    }

    @Override
    public CityOutDto getItemById(Long itemId) {
        return null;
    }

    @Override
    public CityOutDto saveItem(CityInDto item) {
        return null;
    }

    @Override
    public CityOutDto updateItemPartially(Long itemId, CityInDto item) {
        return null;
    }

    @Override
    public CityOutDto updateItem(Long itemId, CityInDto item) {
        return null;
    }

    @Override
    public void deleteItem(Long id) {

    }
}

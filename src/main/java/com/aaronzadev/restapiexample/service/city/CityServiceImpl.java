package com.aaronzadev.restapiexample.service.city;

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
    public Page<CityEntity> getAllItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return cityRepo.findAll(pageable);
    }

    @Override
    public CityEntity getItemById(Long itemId) {
        return cityRepo.findById(itemId).orElse(new CityEntity());
    }

    @Override
    public CityEntity saveItem(CityEntity item) {
        return cityRepo.save(item);
    }

    @Override
    public CityEntity updateItemPartial(Long itemId, CityEntity item) {
        return cityRepo.save(item);
    }

    @Override
    public CityEntity updateItem(Long itemId, CityEntity item) {
        return cityRepo.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        cityRepo.deleteById(id);
    }
}

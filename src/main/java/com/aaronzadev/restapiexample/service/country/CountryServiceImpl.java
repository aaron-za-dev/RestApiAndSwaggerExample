package com.aaronzadev.restapiexample.service.country;

import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import com.aaronzadev.restapiexample.persistence.repository.ICountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService{

    private final ICountryRepo countryRepo;

    @Autowired
    public CountryServiceImpl(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public Page<CountryEntity> getAllItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return countryRepo.findAll(pageable);
    }

    @Override
    public CountryEntity getItemById(Long itemId) {
        return countryRepo.findById(itemId).orElse(new CountryEntity());
    }

    @Override
    public CountryEntity saveItem(CountryEntity item) {
        return countryRepo.save(item);
    }

    @Override
    public CountryEntity updateItemPartial(Long itemId, CountryEntity item) {
        return countryRepo.save(item);
    }

    @Override
    public CountryEntity updateItem(Long itemId, CountryEntity item) {
        return countryRepo.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        countryRepo.deleteById(id);
    }
}

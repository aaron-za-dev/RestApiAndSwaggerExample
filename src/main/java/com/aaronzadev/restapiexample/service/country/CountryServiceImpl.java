package com.aaronzadev.restapiexample.service.country;

import com.aaronzadev.restapiexample.exceptions.RecordNotFoundException;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import com.aaronzadev.restapiexample.persistence.repository.ICountryRepo;
import com.aaronzadev.restapiexample.service.mappers.country.ICountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService{

    private final ICountryRepo countryRepo;
    private final ICountryMapper countryMapper;

    @Autowired
    public CountryServiceImpl(ICountryRepo countryRepo, ICountryMapper countryMapper) {
        this.countryRepo = countryRepo;
        this.countryMapper = countryMapper;
    }

    @Override
    public Page<CountryOutDto> getPagedItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return countryRepo.findAll(pageable).map(countryMapper::mapToOutDto);//countryRepo.findAll(pageable);
    }

    @Override
    public CountryOutDto getItemById(Long itemId) {
        return countryRepo.findById(itemId)
                          .map(countryMapper::mapToOutDto)
                          .orElseThrow(() -> new RecordNotFoundException("Country with Key/ID ".concat(String.valueOf(itemId)).concat(" not exists")));
    }

    @Override
    public CountryOutDto saveItem(CountryInDto item) {
        CountryEntity mapped = countryMapper.mapToEntity(item);
        return countryMapper.mapToOutDto(countryRepo.save(mapped));
    }

    @Override
    public CountryOutDto updateItemPartially(Long itemId, CountryInDto item) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public CountryOutDto updateItem(Long itemId, CountryInDto item) {

        CountryEntity mapped = countryMapper.mapToEntity(itemId, item);

        CountryEntity saved = countryRepo.findById(itemId).orElseThrow(() -> new RecordNotFoundException(""));
        //TODO this can be simplified
        if (!saved.equals(mapped)){
            return countryMapper.mapToOutDto(countryRepo.save(mapped));
        }
        else {
            return countryMapper.mapToOutDto(saved);
        }

    }

    @Override
    public void deleteItem(Long itemId) {
        if (!countryRepo.existsById(itemId)){
            throw new RecordNotFoundException("Country with Key/ID ".concat(String.valueOf(itemId)).concat(" not exists"));
        }
        countryRepo.deleteById(itemId);
    }
}

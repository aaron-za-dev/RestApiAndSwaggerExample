package com.aaronzadev.restapiexample.service.country;

import com.aaronzadev.restapiexample.exceptions.RecordNotFoundException;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.service.mappers.country.ICountryMapper;
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
    private final ICountryMapper countryMapper;

    @Autowired
    public CountryServiceImpl(ICountryRepo countryRepo, ICountryMapper countryMapper) {
        this.countryRepo = countryRepo;
        this.countryMapper = countryMapper;
    }

    @Override
    public Page<CountryOutDto> getAllItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return countryRepo.findAll(pageable).map(countryMapper::mapToOutDto);//countryRepo.findAll(pageable);
    }

    @Override
    public CountryOutDto getItemById(Long itemId) {
        return countryRepo.findById(itemId)
                          .map(countryMapper::mapToOutDto)
                          .orElseThrow(() -> new RecordNotFoundException("Country with ID: ".concat(String.valueOf(itemId)).concat(" not found!")));
    }

    @Override //TODO check if exists before perform save
    public CountryOutDto saveItem(CountryInDto item) {
        CountryEntity mapped = countryMapper.mapToEntity(item);
        return countryMapper.mapToOutDto(countryRepo.save(mapped));//countryRepo.save(item);
    }

    @Override
    public CountryOutDto updateItemPartial(Long itemId, CountryInDto item) {
        CountryEntity mapped = countryMapper.mapToEntity(item);
        return countryMapper.mapToOutDto(countryRepo.save(mapped));//countryRepo.save(item);
    }

    @Override
    public CountryOutDto updateItem(Long itemId, CountryInDto item) {
        CountryEntity mapped = countryMapper.mapToEntity(item);
        return countryMapper.mapToOutDto(countryRepo.save(mapped));//countryRepo.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        countryRepo.deleteById(id);
    }
}

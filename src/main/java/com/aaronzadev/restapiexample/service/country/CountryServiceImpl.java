package com.aaronzadev.restapiexample.service.country;

import com.aaronzadev.restapiexample.exceptions.RecordNotFoundException;
import com.aaronzadev.restapiexample.mappers.country.ICountryMapper;
import com.aaronzadev.restapiexample.mappers.page.IPageMapper;
import com.aaronzadev.restapiexample.persistence.dto.page.PageOutDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;
import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import com.aaronzadev.restapiexample.persistence.repository.ICountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService{

    private final ICountryRepo countryRepo;
    private final ICountryMapper countryMapper;
    private final IPageMapper pageMapper;

    @Autowired
    public CountryServiceImpl(ICountryRepo countryRepo, ICountryMapper countryMapper, IPageMapper pageMapper) {
        this.countryRepo = countryRepo;
        this.countryMapper = countryMapper;
        this.pageMapper = pageMapper;
    }

    @Override
    public PageOutDto getPagedItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CountryOutDto> pageResult = countryRepo.findAll(pageable).map(countryMapper::mapToOutDto);
        return pageMapper.mapToPageOutDto(pageResult);
    }

    @Override
    public CountryOutDto getItemById(Long itemId) {
        return countryRepo.findById(itemId)
                          .map(countryMapper::mapToOutDto)
                          .orElseThrow(() -> new RecordNotFoundException("Country with Key/ID "+ itemId +" not exists"));
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

        if(!countryRepo.existsById(itemId)){
            throw new RecordNotFoundException("Country with Key/ID "+ itemId +" not exists");
        }

        CountryEntity mapped = countryMapper.mapToEntity(itemId, item);

        return countryMapper.mapToOutDto(countryRepo.save(mapped));

    }

    @Override
    public void deleteItem(Long itemId) {
        if (!countryRepo.existsById(itemId)){
            throw new RecordNotFoundException("Country with Key/ID "+ itemId +" not exists");
        }
        countryRepo.deleteById(itemId);
    }

    @Override
    public PageOutDto getPagedCountries(int page, int pageSize, String sortingField, String sortingDirection) {
        Sort sort = (sortingDirection.equals("DESC")) ? Sort.by(sortingField).descending() : Sort.by(sortingField).ascending();
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<CountryOutDto> pageResult = countryRepo.findAll(pageable).map(countryMapper::mapToOutDto);
        return pageMapper.mapToPageOutDto(pageResult);
    }

    @Override
    public boolean checkIfExists(Long countryId) {
        if (countryRepo.existsById(countryId)) {
            return true;
        } else {
            throw new RecordNotFoundException("Country with Key/ID "+ countryId +" not exists");
        }
    }
}

package com.aaronzadev.restapiexample.service.city;

import com.aaronzadev.restapiexample.exceptions.RecordNotFoundException;
import com.aaronzadev.restapiexample.mappers.city.ICityMapper;
import com.aaronzadev.restapiexample.mappers.page.IPageMapper;
import com.aaronzadev.restapiexample.persistence.dto.page.PageOutDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityInDto;
import com.aaronzadev.restapiexample.persistence.dto.city.CityOutDto;
import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import com.aaronzadev.restapiexample.persistence.repository.ICityRepo;
import com.aaronzadev.restapiexample.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService {

    private final ICityRepo cityRepo;

    private final ICityMapper cityMapper;

    private final IPageMapper pageMapper;

    private final ICountryService countryService;

    @Autowired
    public CityServiceImpl(ICityRepo cityRepo, ICityMapper cityMapper, IPageMapper pageMapper, ICountryService countryService) {
        this.cityRepo = cityRepo;
        this.cityMapper = cityMapper;
        this.pageMapper = pageMapper;
        this.countryService = countryService;
    }

    @Override
    public PageOutDto getPagedItems(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CityOutDto> pageResult = cityRepo.findAll(pageable).map(cityMapper::mapToOutDto);
        return pageMapper.mapToPageOutDto(pageResult);
    }

    @Override
    public CityOutDto getItemById(Long itemId) {
        return cityRepo.findById(itemId)
                .map(cityMapper::mapToOutDto)
                .orElseThrow(() -> new RecordNotFoundException("City with Key/ID "+ itemId +" not exists"));
    }

    @Override
    public CityOutDto saveItem(CityInDto item) {
        CityEntity mapped = cityMapper.mapToEntity(item);
        mapped.setCountry(getCountryParent(item.countryId()));
        return cityMapper.mapToOutDto(cityRepo.save(mapped));
    }

    @Override
    public CityOutDto updateItemPartially(Long itemId, CityInDto item) { //TODO add validations
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public CityOutDto updateItem(Long itemId, CityInDto item) {

        if(!cityRepo.existsById(itemId)){
            throw new RecordNotFoundException("City with Key/ID "+ itemId +" not exists");
        }

        CityEntity mapped = cityMapper.mapToEntity(itemId, item);

        mapped.setCountry(getCountryParent(item.countryId()));

        return cityMapper.mapToOutDto(cityRepo.save(mapped));

    }

    @Override
    public void deleteItem(Long id) {
        if (!cityRepo.existsById(id)){
            throw new RecordNotFoundException("City with Key/ID "+ id +" not exists");
        }
        cityRepo.deleteById(id);
    }

    private CountryEntity getCountryParent(Long countryId){
        CountryEntity countryEntity = new CountryEntity();
        if (countryService.checkIfExists(countryId)){
            countryEntity.setCountryId(countryId);
            return countryEntity;
        }
        return countryEntity;
    }
}

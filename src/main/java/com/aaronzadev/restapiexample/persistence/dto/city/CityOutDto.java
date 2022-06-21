package com.aaronzadev.restapiexample.persistence.dto.city;

import com.aaronzadev.restapiexample.persistence.dto.country.CountryOutDto;

import java.sql.Timestamp;

public record CityOutDto(Long cityId, String cityName, CountryOutDto country, Timestamp lastUpdate) {
}

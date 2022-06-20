package com.aaronzadev.restapiexample.persistence.dto.city;

import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;

import java.io.Serializable;

//TODO TO TEST
public record CityDto(String cityName, CountryInDto country) implements Serializable {
}

package com.aaronzadev.restapiexample.persistence.dto.city;

import com.aaronzadev.restapiexample.persistence.dto.country.CountryInDto;

import java.io.Serializable;

//TODO add validations
public record CityInDto(String cityName, CountryInDto country) implements Serializable {}

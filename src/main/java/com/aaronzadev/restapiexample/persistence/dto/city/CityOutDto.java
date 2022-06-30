package com.aaronzadev.restapiexample.persistence.dto.city;

import java.sql.Timestamp;

public record CityOutDto(Long cityId, String cityName, Timestamp lastUpdate) {
}

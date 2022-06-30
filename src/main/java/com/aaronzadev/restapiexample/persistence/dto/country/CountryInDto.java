package com.aaronzadev.restapiexample.persistence.dto.country;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public record CountryInDto(
        Long countryId,
        @NotEmpty(message = "Country name is mandatory") //TODO 18in messages of validation
        @Size(min = 4, max = 50, message = "Country name must be between 4 and 50 characters")
        String countryName
) implements Serializable {}

//TODO change Dto to transformations
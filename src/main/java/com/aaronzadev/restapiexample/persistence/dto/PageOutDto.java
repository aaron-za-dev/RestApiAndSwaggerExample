package com.aaronzadev.restapiexample.persistence.dto;

import java.util.List;

public record PageOutDto(
        List<?> items,
        boolean firstPage,
        boolean lastPage,
        Integer prevPage,
        Integer currentPage,
        Integer nextPage,
        Integer pageSize,
        Integer totalPages,
        Long totalItems) {
}

package com.aaronzadev.restapiexample.service;

import org.springframework.data.domain.Page;

public interface IGenericService<T, S> {

    Page<T> getAllItems(int page, int pageSize);

    T getSingleItem(Long itemId);

    T saveItem(T entity);

    T updateItem(T entity);

    void deleteItem(Long itemId);

    S mapEntityToDto(T entity);

    T mapDtoToEntity(S dto);


}

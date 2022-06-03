package com.aaronzadev.restapiexample.service;

import org.springframework.data.domain.Page;

public interface IGenericService<T> {

    Page<T> getAllItems(int page, int pageSize);

    T getItemById(Long itemId);

    T saveItem(T item);

    T updateItemPartial(Long itemId, T item);

    T updateItem(Long itemId, T item);

    void deleteItem(Long id);

    /*T mapEntityToDto(S entity);

    S mapDtoToEntity(T dto);*/


}

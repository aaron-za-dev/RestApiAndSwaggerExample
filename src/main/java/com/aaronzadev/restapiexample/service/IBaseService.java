package com.aaronzadev.restapiexample.service;

import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;

public interface IBaseService<T, U> {

    PageOutDto getPagedItems(int page, int pageSize);

    T getItemById(Long itemId);

    T saveItem(U item);

    T updateItemPartially(Long itemId, U item);

    T updateItem(Long itemId, U item);

    void deleteItem(Long id);

}

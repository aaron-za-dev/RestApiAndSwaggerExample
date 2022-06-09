package com.aaronzadev.restapiexample.service;

import org.springframework.data.domain.Page;

public interface IBaseService<T, S> {

    Page<T> getAllItems(int page, int pageSize);

    T getItemById(Long itemId);

    T saveItem(S item);

    T updateItemPartial(Long itemId, S item);

    T updateItem(Long itemId, S item);

    void deleteItem(Long id);

}

package com.aaronzadev.restapiexample.controller;


import org.springframework.data.domain.Page;

public interface IBaseController<T> {

    //get all
    Page<T> getPage(int page, int pageSize);

    //get single by id
    T getById(Long itemId);

    //post
    T saveItem(T item);

    //patch
    T partialUpdate(Long itemId, T item);

    //update
    T completeUpdate(Long itemId, T item);

    //delete
    void deleteItem(Long itemId);

}

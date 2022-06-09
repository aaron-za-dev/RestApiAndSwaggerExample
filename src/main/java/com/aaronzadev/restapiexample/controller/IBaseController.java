package com.aaronzadev.restapiexample.controller;


import org.springframework.data.domain.Page;

public interface IBaseController<T, S> {

    //get all
    Page<T> getPage(int page, int pageSize);

    //get single by id
    T getById(Long itemId);

    //post
    T saveItem(S item);

    //patch
    T partialUpdate(Long itemId, S item);

    //update
    T completeUpdate(Long itemId, S item);

    //delete
    void deleteItem(Long itemId);

}

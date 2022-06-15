package com.aaronzadev.restapiexample.controller;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IBaseController<T, S> {

    //get all
    ResponseEntity<Page<T>> getPagedItems(int page, int pageSize);

    //Page<T> getPage(int page, int pageSize);

    //get single by id
    ResponseEntity<T> getItemById(Long itemId);

    //post
    ResponseEntity<T> saveItem(S item);

    //patch
    ResponseEntity<T> updateItemPartially(Long itemId, S item);

    //update
    ResponseEntity<T> updateItem(Long itemId, S item);

    //delete
    void deleteItem(Long itemId);

}

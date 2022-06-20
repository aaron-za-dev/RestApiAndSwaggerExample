package com.aaronzadev.restapiexample.controller;


import com.aaronzadev.restapiexample.persistence.dto.PageOutDto;
import org.springframework.http.ResponseEntity;

public interface IBaseController<T, U> {

    //get all
    ResponseEntity<PageOutDto> getPagedItems(int page, int pageSize);

    //get single by id
    ResponseEntity<T> getItemById(Long itemId);

    //post
    ResponseEntity<T> saveItem(U item);

    //patch
    ResponseEntity<T> updateItemPartially(Long itemId, U item);

    //update
    ResponseEntity<T> updateItem(Long itemId, U item);

    //delete
    void deleteItem(Long itemId);

}

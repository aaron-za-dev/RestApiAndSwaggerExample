package com.aaronzadev.restapiexample.persistence.repository;

import com.aaronzadev.restapiexample.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
}

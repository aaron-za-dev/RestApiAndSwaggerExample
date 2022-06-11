package com.aaronzadev.restapiexample.persistence.repository;

import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepo extends JpaRepository<CountryEntity, Long> {
}

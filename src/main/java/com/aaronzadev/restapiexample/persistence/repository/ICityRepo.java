package com.aaronzadev.restapiexample.persistence.repository;

import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepo extends JpaRepository<CityEntity, Long> {
}

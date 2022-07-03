package com.aaronzadev.restapiexample.persistence.repository;

import com.aaronzadev.restapiexample.persistence.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends JpaRepository<CityEntity, Long> {

    //TODO avoid count query. This is an example
    /*@Query(value = "SELECT city_id AS cityId, city AS cityName, country AS countryName, city.last_update AS lastUpdated FROM country INNER JOIN city USING (country_id)",
           countQuery = "select count(city_id) from city", nativeQuery = true)
    Page<TestDto> findAllWithCountry(Pageable pageable);*/

}

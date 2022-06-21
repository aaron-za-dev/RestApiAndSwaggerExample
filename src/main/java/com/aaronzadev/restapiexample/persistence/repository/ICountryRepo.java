package com.aaronzadev.restapiexample.persistence.repository;

import com.aaronzadev.restapiexample.persistence.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepo extends JpaRepository<CountryEntity, Long> {

    /*@Query(value = "SELECT country_id, country, last_update, COUNT(*) OVER() AS Total FROM country ", nativeQuery = true)
    @Query(value = "SELECT * COUNT(*) OVER() AS total FROM country", nativeQuery = true)
    List<CountryEntity> findAllx(Pageable pageable);*/

}

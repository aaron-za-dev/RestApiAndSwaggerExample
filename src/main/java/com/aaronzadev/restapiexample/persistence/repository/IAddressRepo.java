package com.aaronzadev.restapiexample.persistence.repository;

import com.aaronzadev.restapiexample.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<AddressEntity, Long> {
}

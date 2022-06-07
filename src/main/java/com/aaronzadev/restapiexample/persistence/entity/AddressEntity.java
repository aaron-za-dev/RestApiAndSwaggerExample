package com.aaronzadev.restapiexample.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "address")
public class AddressEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private int addressId;
    
    @Column(name = "address", nullable = false, length = 50)
    private String address;
    
    @Column(name = "address2", length = 50)
    private String address2;
    
    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
    
    @Column(name = "postal_code", length = 10)
    private String postalCode;
    
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    
    @Column(name = "location", nullable = false)
    private Object location;
    
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

}

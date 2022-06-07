package com.aaronzadev.restapiexample.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private int cityId;

    @Column(name = "city", nullable = false, length = 50)
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AddressEntity> addresses;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

}

package com.aaronzadev.restapiexample.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "city", nullable = false, length = 50)
    private String cityName;

    /*@OneToMany(mappedBy = "city", cascade = { CascadeType.ALL })
    private List<AddressEntity> addresses;*/

    //For bidirectional relationship with countryEntity
    @ManyToOne()
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private CountryEntity country;

    @Column(name = "last_update", nullable = false) //TODO check change for type
    private Timestamp lastUpdate;

}

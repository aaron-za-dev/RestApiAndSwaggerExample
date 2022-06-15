package com.aaronzadev.restapiexample.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @NotEmpty(message = "Country name is mandatory")
    @Size(min = 4, max = 50, message = "Country name must be between 4 and 50 characters")
    @Column(name = "country", length = 50, nullable = false)
    private String countryName;

    //For bidirectional relationship
    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<CityEntity> cities;

    /*For unidirectional relationship
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<CityEntity> cities;*/

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

}

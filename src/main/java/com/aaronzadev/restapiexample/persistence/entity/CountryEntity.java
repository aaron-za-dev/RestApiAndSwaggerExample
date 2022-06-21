package com.aaronzadev.restapiexample.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class CountryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @NotEmpty(message = "Country name is mandatory")
    @Size(min = 4, max = 50, message = "Country name must be between 4 and 50 characters")
    @Column(name = "country", length = 50, nullable = false)
    private String countryName;

    //For bidirectional relationship with cityEntity
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CityEntity> cities = new ArrayList<>();

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate; //TODO check change Typo

    /* //This is the best practice
    public void addCity(CityEntity city){
        this.cities.add(city);
        city.setCountry(this);
    }

    public void removeCity(CityEntity city){
        city.setCountry(null);
        this.cities.remove(city);
    }

    public void removeCities(){
        Iterator<CityEntity> cityIterator = this.cities.iterator();
        while(cityIterator.hasNext()){
            CityEntity city = cityIterator.next();
            city.setCountry(null);
            cityIterator.remove();
        }
    }

    @Override
    public String toString() {
        return "CountryEntity{ countryId: " + countryId + ", countryName=: " + countryName +", lastUpdate: " + lastUpdate +"}";
    }*/
}

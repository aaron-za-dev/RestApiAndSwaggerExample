package com.aaronzadev.restapiexample.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "city")
public class CityEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "city", nullable = false, length = 50)
    private String cityName;

    //For bidirectional relationship with countryEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name = "last_update", nullable = false) //TODO check change for type
    private Timestamp lastUpdate;

    /*@Override //This is the best practice
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CityEntity thisObject = (CityEntity) object;
        return Objects.equals(cityId, thisObject.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }

    @Override
    public String toString() {
        return "CityEntity{" + "cityId: " + cityId + ", cityName: " + cityName + ", lastUpdate: " + lastUpdate + "}";
    }*/
}

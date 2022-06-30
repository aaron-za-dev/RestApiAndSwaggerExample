package com.aaronzadev.restapiexample.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

    //For bidirectional relationship with addressEntity
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

    /*//This is the best practice
    public void addAddress(AddressEntity address){
        this.addresses.add(address);
        address.setCity(this);
    }

    public void removeAddress(AddressEntity address){
        address.setCity(null);
        this.addresses.remove(address);
    }

    public void removeAddresses(){
        Iterator<AddressEntity> addressIterator = this.addresses.iterator();
        while(addressIterator.hasNext()){
            AddressEntity address = addressIterator.next();
            address.setCity(null);
            addressIterator.remove();
        }
    }

    @Override
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

package com.aaronzadev.restapiexample.persistence.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false, unique = true)
    private Long addressId;
    
    @Column(name = "address", length = 50, nullable = false)
    private String address;
    
    @Column(name = "address2", length = 50)
    private String address2;
    
    @Column(name = "district", length = 50, nullable = false)
    private String district;

    //For bidirectional relationship with cityEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CityEntity city;
    
    @Column(name = "postal_code", length = 10)
    private String postalCode;
    
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdate;

    @Override //This is the best practice
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AddressEntity thisObject = (AddressEntity) object;
        return Objects.equals(addressId, thisObject.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }

    @Override
    public String toString() {
        return "AddressEntity{" + "addressId: " + addressId + "address: " + address + "address2: " + address2 + "district: " + district + "postalCode: " + postalCode + "phone: " + phone + "lastUpdate=" + lastUpdate + "}";
    }
}

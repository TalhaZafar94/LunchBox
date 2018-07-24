package com.example.lunchbox.model.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "address_postalcode")
    private Integer addressPostalCode;

    @Column(name = "address_lastupdated")
    private Date addressLastUpdated;

    public Address() {
    }

    public Address(Integer addressId, String address, String city, Integer addressPostalCode, Date addressLastUpdated) {
        this.addressId = addressId;
        this.address = address;
        this.city = city;
        this.addressPostalCode = addressPostalCode;
        this.addressLastUpdated = addressLastUpdated;
    }

    public Integer getAddressId() {
        return addressId;
    }


    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(Integer addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public String getAddressLastUpdated() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(addressLastUpdated);
    }

    public void setAddressLastUpdated(Date addressLastUpdated) {
        this.addressLastUpdated = addressLastUpdated;
    }
}

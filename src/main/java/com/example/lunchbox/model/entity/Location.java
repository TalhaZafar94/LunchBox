package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locationId;

    @Column(name = "longitude")
    private Double locationLongitude;

    @Column(name = "latitude")
    private Double locationLatitude;

    @Column(name = "foodmaker_id")
    private Integer foodmakerId;

    @Column(name = "rider_id")
    private Integer riderId;

    @Column(name = "customer_id")
    private Integer customerId;

    public Location() {
    }

    public Location(Double locationLongitude, Double locationLatitude, Integer foodmakerId, Integer riderId, Integer customerId) {
        this.locationLongitude = locationLongitude;
        this.locationLatitude = locationLatitude;
        this.foodmakerId = foodmakerId;
        this.riderId = riderId;
        this.customerId = customerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public Double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public Integer getFoodmakerId() {
        return foodmakerId;
    }

    public void setFoodmakerId(Integer foodmakerId) {
        this.foodmakerId = foodmakerId;
    }

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

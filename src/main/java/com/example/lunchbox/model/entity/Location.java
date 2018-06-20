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

    public Location() {
    }

    public Location(Double locationLongitude, Double locationLatitude,Integer foodmakerId) {
        this.locationLongitude = locationLongitude;
        this.locationLatitude = locationLatitude;
        this.foodmakerId = foodmakerId;
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
}

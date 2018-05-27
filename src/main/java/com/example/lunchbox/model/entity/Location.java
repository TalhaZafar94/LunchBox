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
    private Long locationLongitude;

    @Column(name = "latitude")
    private Long locationLatitude;

    public Location() {
    }

    public Location(Long locationLongitude, Long locationLatitude) {
        this.locationLongitude = locationLongitude;
        this.locationLatitude = locationLatitude;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Long getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Long locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public Long getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Long locationLatitude) {
        this.locationLatitude = locationLatitude;
    }
}

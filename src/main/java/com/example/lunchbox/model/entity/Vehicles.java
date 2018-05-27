package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicles {

    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vehicleId;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "vehicle_name")
    private String vehicleName;

    public Vehicles() {
    }

    public Vehicles(String vehicleNumber, String vehicleName) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}

package com.example.lunchbox.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "riders", indexes = {@Index(name = "EMAIL_INDEX", columnList = "rider_email,rider_nic")})
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rider_id")
    private Integer riderId;

    @Column(name = "rider_name")
    private String riderName;

    @Column(name = "vehicle_id")
    private Integer riderVehicleId;

    @Column(name = "rider_nic", unique = true)
    private String riderNic;

    @Column(name = "rider_password")
    private String riderPassword;

    @Column(name = "address_id")
    private Integer riderAddresId;

    @Column(name = "rider_email", unique = true)
    private String riderEmail;

    @Column(name = "rider_accesstype")
    private Integer riderAccessType;

    @Column(name = "Rider_imagepath")
    private String riderImagePath;

    @Column(name = "rider_active")
    private Integer riderActive;

    @Column(name = "rider_phonenumber")
    private String riderPhoneNumber;

    @Column(name = "admin_id")
    private Integer riderAdminId;

    @Column(name = "rider_createdat", columnDefinition = "DATETIME")
    private Date riderCreatedAt;

    @Column(name = "rider_lastupdated", columnDefinition = "DATETIME")
    private Date riderLastUpdated;

    @Column(name = "location_id", unique = true)
    private Integer riderLocationId;

    @Column(name = "rider_reg_token")
    private String riderRegToken;

    public Rider() {
    }

    public Rider(String riderName, String riderEmail, Integer riderVehicleId, String riderNic, String riderPassword, Integer riderAddresId, Integer riderAccessType, String riderImagePath, Integer riderActive, String riderPhoneNumber, Integer riderAdminId, Date riderCreatedAt, Date riderLastUpdated, Integer riderLocationId, String riderRegToken) {
        this.riderName = riderName;
        this.riderVehicleId = riderVehicleId;
        this.riderNic = riderNic;
        this.riderPassword = riderPassword;
        this.riderAddresId = riderAddresId;
        this.riderAccessType = riderAccessType;
        this.riderImagePath = riderImagePath;
        this.riderActive = riderActive;
        this.riderPhoneNumber = riderPhoneNumber;
        this.riderAdminId = riderAdminId;
        this.riderCreatedAt = riderCreatedAt;
        this.riderLastUpdated = riderLastUpdated;
        this.riderLocationId = riderLocationId;
        this.riderEmail = riderEmail;
        this.riderRegToken = riderRegToken;
    }

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    public String getRiderName() {
        return riderName;
    }

    public String getRiderEmail() {
        return riderEmail;
    }

    public void setRiderEmail(String riderEmail) {
        this.riderEmail = riderEmail;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public Integer getRiderVehicleId() {
        return riderVehicleId;
    }

    public void setRiderVehicleId(Integer riderVehicleId) {
        this.riderVehicleId = riderVehicleId;
    }

    public String getRiderNic() {
        return riderNic;
    }

    public void setRiderNic(String riderNic) {
        this.riderNic = riderNic;
    }

    public String getRiderPassword() {
        return riderPassword;
    }

    public void setRiderPassword(String riderPassword) {
        this.riderPassword = riderPassword;
    }

    public Integer getRiderAddresId() {
        return riderAddresId;
    }

    public void setRiderAddresId(Integer riderAddresId) {
        this.riderAddresId = riderAddresId;
    }

    public Integer getRiderAccessType() {
        return riderAccessType;
    }

    public void setRiderAccessType(Integer riderAccessType) {
        this.riderAccessType = riderAccessType;
    }

    public String getRiderImagePath() {
        return riderImagePath;
    }

    public void setRiderImagePath(String riderImagePath) {
        this.riderImagePath = riderImagePath;
    }

    public Integer getRiderActive() {
        return riderActive;
    }

    public void setRiderActive(Integer riderActive) {
        this.riderActive = riderActive;
    }

    public String getRiderPhoneNumber() {
        return riderPhoneNumber;
    }

    public void setRiderPhoneNumber(String riderPhoneNumber) {
        this.riderPhoneNumber = riderPhoneNumber;
    }

    public Integer getRiderAdminId() {
        return riderAdminId;
    }

    public void setRiderAdminId(Integer riderAdminId) {
        this.riderAdminId = riderAdminId;
    }

    public Date getRiderCreatedAt() {
        return riderCreatedAt;
    }

    public void setRiderCreatedAt(Date riderCreatedAt) {
        this.riderCreatedAt = riderCreatedAt;
    }

    public Date getRiderLastUpdated() {
        return riderLastUpdated;
    }

    public void setRiderLastUpdated(Date riderLastUpdated) {
        this.riderLastUpdated = riderLastUpdated;
    }

    public Integer getRiderLocationId() {
        return riderLocationId;
    }

    public void setRiderLocationId(Integer riderLocationId) {
        this.riderLocationId = riderLocationId;
    }

    public String getRiderRegToken() {
        return riderRegToken;
    }

    public void setRiderRegToken(String riderRegToken) {
        this.riderRegToken = riderRegToken;
    }
}

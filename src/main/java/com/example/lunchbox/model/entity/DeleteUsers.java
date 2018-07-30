package com.example.lunchbox.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
public class DeleteUsers {

    @Id
    @Column(name = "delete_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deleteId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cnic")
    private String cnic;

    @Column(name = "access_type")
    private Integer accessType;

    @Column(name = "password")
    private String password;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date lastUpdated;

    public DeleteUsers() {
    }

    public DeleteUsers(String name, String email, String cnic, Integer accessType, String password, Integer addressId, String imagePath, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.cnic = cnic;
        this.accessType = accessType;
        this.password = password;
        this.addressId = addressId;
        this.imagePath = imagePath;
        this.phoneNumber = phoneNumber;
    }

    public Integer getAdminId() {
        return deleteId;
    }

    public void setAdminId(Integer adminId) {
        this.deleteId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

package com.example.lunchbox.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "admins", indexes = {@Index(name = "EMAIL_INDEX", columnList = "admin_email,admin_nic")})
public class Admin {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_email", unique = true)
    private String adminEmail;

    @Column(name = "admin_nic", unique = true)
    private String adminNic;

    @Column(name = "admin_accesstype")
    private Integer adminAccessType;

    @Column(name = "admin_password")
    private String adminPassword;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address adminAddressId;

    @Column(name = "admin_imagepath")
    private String adminImage;

    @Column(name = "admin_phonenumber")
    private String adminPhoneNumber;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(name = "admin_createdat")
    private Date adminCreatedAt;


    @Column(name = "admin_lastupdated")
    private Timestamp adminLastUpdated;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminEmail, String adminNic, Integer adminAccessType, String adminPassword, Address adminAddressId, String adminImage, String adminPhoneNumber, Date adminCreatedAt, Timestamp adminLastUpdated) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminNic = adminNic;
        this.adminAccessType = adminAccessType;
        this.adminPassword = adminPassword;
        this.adminAddressId = adminAddressId;
        this.adminImage = adminImage;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminCreatedAt = adminCreatedAt;
        this.adminLastUpdated = adminLastUpdated;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminNic() {
        return adminNic;
    }

    public void setAdminNic(String adminNic) {
        this.adminNic = adminNic;
    }

    public Integer getAdminAccessType() {
        return adminAccessType;
    }

    public void setAdminAccessType(Integer adminAccessType) {
        this.adminAccessType = adminAccessType;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Address getAdminAddressId() {
        return adminAddressId;
    }

    public void setAdminAddressId(Address adminAddressId) {
        this.adminAddressId = adminAddressId;
    }

    public String getAdminImage() {
        return adminImage;
    }

    public void setAdminImage(String adminImagePath) {
        this.adminImage = adminImagePath;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public Date getAdminCreatedAt() {
        return adminCreatedAt;
    }

    public void setAdminCreatedAt(Date adminCreatedAt) {
        this.adminCreatedAt = adminCreatedAt;
    }

    public Timestamp getAdminLastUpdated() {
        return adminLastUpdated;
    }

    public void setAdminLastUpdated(Timestamp adminLastUpdated) {
        this.adminLastUpdated = adminLastUpdated;
    }
}

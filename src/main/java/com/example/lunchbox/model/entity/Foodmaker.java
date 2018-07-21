package com.example.lunchbox.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "foodmakers" , indexes = {@Index(name = "EMAIL_INDEX",columnList = "foodmaker_email,foodmaker_nic" )})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Foodmaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodmaker_id")
    private Integer foodmakerId;

    @Column(name = "foodmaker_name")
    private String foodmakerName;

    @Column(name = "foodmaker_email",unique = true)
    private String foodmakerEmail;

    @Column(name = "foodmaker_nic",unique = true)
    private String foodmakerNic;

    @Column(name = "foodmaker_password")
    private String foodmakerpassword;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address foodmakerAddresId;

    @Column(name = "foodmaker_accesstype")
    private Integer foodmakerAccessType;

    @Column(name = "foodmaker_imagepath")
    private String foodmakerImagePath;

    @Column(name = "foodmaker_active")
    private Integer foodmakerActive;

    @Column(name = "foodmaker_phonenumber")
    private String foodmakerPhoneNumber;

    @Column(name = "admin_id")
    private Integer foodmakerAdminId;

    @Column(name = "foodmaker_createdat")
    private Date foodmakerCreatedAt;

    @Column(name = "foodmaker_lastupdated")
    private Date foodmakerLastUpdated;

    @Column(name = "foodaker_RegToken")
    private String foodmakerRegToken;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodmaker_id", nullable = false)
    private Order order;

    //foodmakerdishes
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodmaker_id", nullable = false)
    private FoodmakerDishes foodmakerDishes;

    private Double averageRatings;

    public Foodmaker() {
    }

    public Foodmaker(String foodmakerName, String foodmakerEmail, String foodmakerNic, String foodmakerpassword, Address foodmakerAddresId, Integer foodmakerAccessType, String foodmakerImagePath, Integer foodmakerActive, String foodmakerPhoneNumber, Integer foodmakerAdminId, Date foodmakerCreatedAt, Date foodmakerLastUpdated,String foodmakerRegToken) {
        this.foodmakerName = foodmakerName;
        this.foodmakerEmail = foodmakerEmail;
        this.foodmakerNic = foodmakerNic;
        this.foodmakerpassword = foodmakerpassword;
        this.foodmakerAddresId = foodmakerAddresId;
        this.foodmakerAccessType = foodmakerAccessType;
        this.foodmakerImagePath = foodmakerImagePath;
        this.foodmakerActive = foodmakerActive;
        this.foodmakerPhoneNumber = foodmakerPhoneNumber;
        this.foodmakerAdminId = foodmakerAdminId;
        this.foodmakerCreatedAt = foodmakerCreatedAt;
        this.foodmakerLastUpdated = foodmakerLastUpdated;
        this.foodmakerRegToken = foodmakerRegToken;
    }

    public Integer getFoodmakerId() {
        return foodmakerId;
    }

    public void setFoodmakerId(Integer foodmakerId) {
        this.foodmakerId = foodmakerId;
    }

    public String getFoodmakerName() {
        return foodmakerName;
    }

    public void setFoodmakerName(String foodmakerName) {
        this.foodmakerName = foodmakerName;
    }

    public String getFoodmakerEmail() {
        return foodmakerEmail;
    }

    public void setFoodmakerEmail(String foodmakerEmail) {
        this.foodmakerEmail = foodmakerEmail;
    }

    public String getFoodmakerNic() {
        return foodmakerNic;
    }

    public void setFoodmakerNic(String foodmakerNic) {
        this.foodmakerNic = foodmakerNic;
    }

    public String getFoodmakerpassword() {
        return foodmakerpassword;
    }

    public void setFoodmakerpassword(String foodmakerpassword) {
        this.foodmakerpassword = foodmakerpassword;
    }

    public Address getFoodmakerAddresId() {
        return foodmakerAddresId;
    }

    public void setFoodmakerAddresId(Address foodmakerAddresId) {
        this.foodmakerAddresId = foodmakerAddresId;
    }

    public Integer getFoodmakerAccessType() {
        return foodmakerAccessType;
    }

    public void setFoodmakerAccessType(Integer foodmakerAccessType) {
        this.foodmakerAccessType = foodmakerAccessType;
    }

    public String getFoodmakerImagePath() {
        return foodmakerImagePath;
    }

    public void setFoodmakerImagePath(String foodmakerImagePath) {
        this.foodmakerImagePath = foodmakerImagePath;
    }

    public Integer getFoodmakerActive() {
        return foodmakerActive;
    }

    public void setFoodmakerActive(Integer foodmakerActive) {
        this.foodmakerActive = foodmakerActive;
    }

    public String getFoodmakerPhoneNumber() {
        return foodmakerPhoneNumber;
    }

    public void setFoodmakerPhoneNumber(String foodmakerPhoneNumber) {
        this.foodmakerPhoneNumber = foodmakerPhoneNumber;
    }

    public Integer getFoodmakerAdminId() {
        return foodmakerAdminId;
    }

    public void setFoodmakerAdminId(Integer foodmakerAdminId) {
        this.foodmakerAdminId = foodmakerAdminId;
    }

    public Date getFoodmakerCreatedAt() {
        return foodmakerCreatedAt;
    }

    public void setFoodmakerCreatedAt(Date foodmakerCreatedAt) {
        this.foodmakerCreatedAt = foodmakerCreatedAt;
    }

    public Date getFoodmakerLastUpdated() {
        return foodmakerLastUpdated;
    }

    public void setFoodmakerLastUpdated(Date foodmakerLastUpdated) {
        this.foodmakerLastUpdated = foodmakerLastUpdated;
    }

    public Double getAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(Double averageRatings) {
        this.averageRatings = averageRatings;
    }

    public String getFoodmakerRegToken() {
        return foodmakerRegToken;
    }

    public void setFoodmakerRegToken(String foodmakerRegToken) {
        this.foodmakerRegToken = foodmakerRegToken;
    }
}

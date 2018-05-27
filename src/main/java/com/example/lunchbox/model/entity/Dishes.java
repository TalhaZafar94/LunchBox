package com.example.lunchbox.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "dishes" , indexes = {@Index(name = "DISH_INDEX",columnList = "dish_name" )})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dishes {


    @Id
    @Column(name = "dish_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dishId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "dish_sellingprice")
    private Double dishSellingPrice;

    @Column(name = "dish_availabletime")
    private Time dishAvailableTime;

    @Column(name = "dish_imagepath")
    private String dishImagePath;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    private Orderdishes orderDishes;

    public Dishes() {
    }

    public Dishes(String dishName, Double dishSellingPrice, Time dishAvailableTime, String dishImagePath) {

        this.dishName = dishName;
        this.dishSellingPrice = dishSellingPrice;
        this.dishAvailableTime = dishAvailableTime;
        this.dishImagePath = dishImagePath;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getDishSellingPrice() {
        return dishSellingPrice;
    }

    public void setDishSellingPrice(Double dishSellingPrice) {
        this.dishSellingPrice = dishSellingPrice;
    }

    public Time getDishAvailableTime() {
        return dishAvailableTime;
    }

    public void setDishAvailableTime(Time dishAvailableTime) {
        this.dishAvailableTime = dishAvailableTime;
    }

    public String getDishImagePath() {
        return dishImagePath;
    }

    public void setDishImagePath(String dishImagePath) {
        this.dishImagePath = dishImagePath;
    }
}

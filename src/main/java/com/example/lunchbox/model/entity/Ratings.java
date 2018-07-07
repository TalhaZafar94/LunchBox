package com.example.lunchbox.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Ratings {

    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ratingId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "foodmaker_id")
    private Integer foodmakerId;

    @Column(name = "stars")
    private Integer stars;

    public Ratings() {
    }

    public Ratings(Integer customerId, Integer foodmakerId, Integer stars) {
        this.customerId = customerId;
        this.foodmakerId = foodmakerId;
        this.stars = stars;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer ratingCustomerId) {
        this.customerId = ratingCustomerId;
    }

    public Integer getFoodmakerId() {
        return foodmakerId;
    }

    public void setFoodmakerId(Integer ratingDishId) {
        this.foodmakerId = ratingDishId;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer ratingStars) {
        this.stars = ratingStars;
    }

}

package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Ratings {

    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ratingId;

    @Column(name = "customer_id")
    private Integer ratingCustomerId;

    @Column(name = "dish_id")
    private Integer ratingDishId;

    @Column(name = "stars")
    private Integer ratingStars;

    public Ratings() {
    }

    public Ratings(Integer ratingCustomerId, Integer ratingDishId, Integer ratingStars) {
        this.ratingCustomerId = ratingCustomerId;
        this.ratingDishId = ratingDishId;
        this.ratingStars = ratingStars;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRatingCustomerId() {
        return ratingCustomerId;
    }

    public void setRatingCustomerId(Integer ratingCustomerId) {
        this.ratingCustomerId = ratingCustomerId;
    }

    public Integer getRatingDishId() {
        return ratingDishId;
    }

    public void setRatingDishId(Integer ratingDishId) {
        this.ratingDishId = ratingDishId;
    }

    public Integer getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(Integer ratingStars) {
        this.ratingStars = ratingStars;
    }
}

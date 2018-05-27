package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "foodmaker_dishes")
public class FoodMakerDishes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodmaker_dishes_id")
    private Integer foodmakerDishesId;

    @Column(name = "dish_id")
    private Integer dishId;

    @Column(name = "foodmaker_id")
    private Integer foodMakerId;

    public FoodMakerDishes() {
    }

    public FoodMakerDishes(Integer dishId, Integer foodMakerId) {
        this.dishId = dishId;
        this.foodMakerId = foodMakerId;
    }

    public Integer getFoodmakerDishesId() {
        return foodmakerDishesId;
    }

    public void setFoodmakerDishesId(Integer foodmakerDishesId) {
        this.foodmakerDishesId = foodmakerDishesId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getFoodMakerId() {
        return foodMakerId;
    }

    public void setFoodMakerId(Integer foodMakerId) {
        this.foodMakerId = foodMakerId;
    }
}

package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "foodmaker_dishes")
public class FoodmakerDishes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "foodmaker_dishes_id")
    private Integer foodmakerDishesId;

    @Column(name = "dish_id")
    private Integer dishId;

    @Column(name = "foodmaker_id")
    private Integer foodmakerid;

    @Column(name = "description")
    private String description;

    @Column(name = "image_path")
    private String imagepath;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "foodmakerDishes", cascade = {CascadeType.ALL})
    private Foodmaker foodmaker;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "fDishes", cascade = {CascadeType.ALL})
    private Dishes dishes;

    public FoodmakerDishes() {
    }

    public FoodmakerDishes(Integer dishId, Integer foodmakerid, String imagepath, String description) {
        this.dishId = dishId;
        this.foodmakerid = foodmakerid;
        this.description = description;
        this.imagepath = imagepath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
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

    public Integer getFoodmakerid() {
        return foodmakerid;
    }

    public void setFoodmakerid(Integer foodmakerid) {
        this.foodmakerid = foodmakerid;
    }

    public Foodmaker getFoodmaker() {
        return foodmaker;
    }

    public void setFoodmaker(Foodmaker foodmaker) {
        this.foodmaker = foodmaker;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }
}

package com.example.lunchbox.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "dishes_categories")
public class Dishescategories {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "dish_id")
    private Integer categoryDishId;

    public Dishescategories() {
    }

    public Dishescategories(String categoryName, Integer categoryDishId) {
        this.categoryName = categoryName;
        this.categoryDishId = categoryDishId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryDishId() {
        return categoryDishId;
    }

    public void setCategoryDishId(Integer categoryDishId) {
        this.categoryDishId = categoryDishId;
    }
}

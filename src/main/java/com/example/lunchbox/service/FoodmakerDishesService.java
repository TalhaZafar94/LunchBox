package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.FoodmakerDishes;

import java.util.List;

public interface FoodmakerDishesService {

    void addDish(FoodmakerDishes foodmakerDishes);
    FoodmakerDishes getFoodmakerDishById(Integer id);
    long countAllFoodMmkerDishes();
    void deleteFoodmakerDish(Integer foodmakerDisheId);
    List<FoodmakerDishes> getFoodmakerDishbyFoodmakerId(int foodmakerId);
    List<FoodmakerDishes> getFoodmakerDishbyDishesId(int dishId);
    List<FoodmakerDishes> findAll();
}
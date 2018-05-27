package com.example.lunchbox.service;

import com.example.lunchbox.model.entity.Dishes;

import java.util.List;

public interface DishService  {
    void addDish(Dishes dish);
    Dishes getDishesById(Integer id);
    long countAllDishes();
    void deleteDishes(Dishes dish);
    List<Dishes> findAllDishes();
}

package com.example.lunchbox.service.Impl;


import com.example.lunchbox.model.entity.FoodmakerDishes;
import com.example.lunchbox.repository.DishRepository;
import com.example.lunchbox.repository.FoodmakerDishesRepository;
import com.example.lunchbox.repository.FoodmakerRepository;
import com.example.lunchbox.service.FoodmakerDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodmakerDishesServiceServiceImpl implements FoodmakerDishesService {

    private FoodmakerDishesRepository foodmakerDishesRepository;
    private FoodmakerRepository foodmakerRepository;
    private DishRepository dishRepository;

    @Autowired
    public FoodmakerDishesServiceServiceImpl(FoodmakerDishesRepository foodmakerDishesRepository,DishRepository dishRepository,
                                             FoodmakerRepository foodmakerRepository) {
        this.foodmakerDishesRepository = foodmakerDishesRepository;
        this.foodmakerRepository = foodmakerRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public void addDish(FoodmakerDishes foodmakerDishes) {
        foodmakerDishesRepository.saveAndFlush(foodmakerDishes);
    }

    @Override
    public FoodmakerDishes getFoodmakerDishById(Integer id) {
        return foodmakerDishesRepository.getOne(id);
    }

    @Override
    public long countAllFoodMmkerDishes() {
        return foodmakerDishesRepository.count();
    }

    @Override
    public void deleteFoodmakerDish(Integer foodmakerDishesId) {
        foodmakerDishesRepository.delete(foodmakerDishesId);
    }

    @Override
    public List<FoodmakerDishes> getFoodmakerDishbyFoodmakerId(int foodmakerId) {

        List<FoodmakerDishes> getAll = new ArrayList<>();
        List<FoodmakerDishes> foodmakerDishes  = foodmakerDishesRepository.getAllByFoodmakerid(foodmakerId);

        for(FoodmakerDishes foodmakerDishes1: foodmakerDishes)
        {
            foodmakerDishes1.setDishes(dishRepository.findOne(foodmakerDishes1.getDishId()));
            foodmakerDishes1.setFoodmaker(foodmakerRepository.findOne(foodmakerId));
            getAll.add(foodmakerDishes1);
        }
        return getAll;
    }

    @Override
    public List<FoodmakerDishes> getFoodmakerDishbyDishesId(int dishId) {

        List<FoodmakerDishes> getAll = new ArrayList<>();
        List<FoodmakerDishes> foodmakerDishes  = foodmakerDishesRepository.getAllByDishId(dishId);

        for(FoodmakerDishes foodmakerDishes1: foodmakerDishes)
        {
            foodmakerDishes1.setDishes(dishRepository.findOne(dishId));
            foodmakerDishes1.setFoodmaker(foodmakerRepository.findOne(foodmakerDishes1.getFoodmakerid()));
            getAll.add(foodmakerDishes1);
        }

        return getAll;
    }

    @Override
    public List<FoodmakerDishes> findAll() {

        List<FoodmakerDishes> getAll = new ArrayList<>();
        List<FoodmakerDishes> foodmakerDishes  = foodmakerDishesRepository.findAll();

        for(FoodmakerDishes foodmakerDishes1: foodmakerDishes)
        {
            foodmakerDishes1.setDishes(dishRepository.findOne(foodmakerDishes1.getDishId()));
            foodmakerDishes1.setFoodmaker(foodmakerRepository.findOne(foodmakerDishes1.getFoodmakerid()));
            getAll.add(foodmakerDishes1);
        }
        return getAll;
    }
}

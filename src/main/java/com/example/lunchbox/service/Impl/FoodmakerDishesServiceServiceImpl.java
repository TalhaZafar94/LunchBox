package com.example.lunchbox.service.Impl;


import com.example.lunchbox.model.entity.Dishes;
import com.example.lunchbox.model.entity.FoodmakerDishes;
import com.example.lunchbox.model.entity.Order;
import com.example.lunchbox.repository.DishRepository;
import com.example.lunchbox.repository.FoodmakerDishesRepository;
import com.example.lunchbox.repository.FoodmakerRepository;
import com.example.lunchbox.repository.OrderRepository;
import com.example.lunchbox.service.FoodmakerDishesService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodmakerDishesServiceServiceImpl implements FoodmakerDishesService {

    private FoodmakerDishesRepository foodmakerDishesRepository;
    private FoodmakerRepository foodmakerRepository;
    private DishRepository dishRepository;
    private OrderRepository orderRepository;

    @Autowired
    public FoodmakerDishesServiceServiceImpl(FoodmakerDishesRepository foodmakerDishesRepository, DishRepository dishRepository,
                                             FoodmakerRepository foodmakerRepository, OrderRepository orderRepository) {
        this.foodmakerDishesRepository = foodmakerDishesRepository;
        this.foodmakerRepository = foodmakerRepository;
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
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
        List<FoodmakerDishes> foodmakerDishes = foodmakerDishesRepository.getAllByFoodmakerid(foodmakerId);

        for (FoodmakerDishes foodmakerDishes1 : foodmakerDishes) {
            foodmakerDishes1.setDishes(dishRepository.findOne(foodmakerDishes1.getDishId()));
            foodmakerDishes1.setFoodmaker(foodmakerRepository.findOne(foodmakerId));
            getAll.add(foodmakerDishes1);
        }
        return getAll;
    }


    @Override
    public List<Dishes> getDishbyorderId(int orderId) {
        List<Dishes> dishesList = new ArrayList<>();

        Order order = orderRepository.getOne(orderId);

        for (int i = 0; i <= order.getOrderdishes().size(); i++) {
            dishesList.add(dishRepository.findOne(i));
        }

        if (dishesList.size() > 0) {
            return dishesList;
        }

        return null;
    }


    @Override
    public List<FoodmakerDishes> getFoodmakerDishbyDishesId(int dishId) {

        List<FoodmakerDishes> getAll = new ArrayList<>();
        List<FoodmakerDishes> foodmakerDishes = foodmakerDishesRepository.getAllByDishId(dishId);

        for (FoodmakerDishes foodmakerDishes1 : foodmakerDishes) {
            foodmakerDishes1.setDishes(dishRepository.findOne(dishId));
            foodmakerDishes1.setFoodmaker(foodmakerRepository.findOne(foodmakerDishes1.getFoodmakerid()));
            getAll.add(foodmakerDishes1);
        }

        return getAll;
    }

    @Override
    public List<FoodmakerDishes> findAll() {

        List<FoodmakerDishes> getAll = new ArrayList<>();
        List<FoodmakerDishes> foodmakerDishes = foodmakerDishesRepository.findAll();

        for (FoodmakerDishes foodmakerDishes1 : foodmakerDishes) {
            foodmakerDishes1.setDishes(dishRepository.findOne(foodmakerDishes1.getDishId()));
            foodmakerDishes1.setFoodmaker(foodmakerRepository.findOne(foodmakerDishes1.getFoodmakerid()));
            getAll.add(foodmakerDishes1);
        }
        return getAll;
    }
}

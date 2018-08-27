package com.example.lunchbox.service.Impl;

import com.example.lunchbox.model.entity.Dishes;
import com.example.lunchbox.repository.DishRepository;
import com.example.lunchbox.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public void addDish(Dishes dish) {
        dishRepository.saveAndFlush(dish);
    }

    @Override
    public Dishes getDishesById(Integer id) {
        return dishRepository.findOne(id);
    }

    @Override
    public long countAllDishes() {
        return dishRepository.count();
    }

    @Override
    public void deleteDishes(Dishes dish) {
        dishRepository.delete(dish);
    }

    @Override
    public List<Dishes> findAllDishes() {
        return dishRepository.findAll();
    }
}

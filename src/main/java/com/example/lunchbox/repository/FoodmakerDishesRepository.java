package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.FoodmakerDishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodmakerDishesRepository extends JpaRepository<FoodmakerDishes, Integer> {

    List<FoodmakerDishes> getAllByFoodmakerid(Integer foodmakerId);
    List<FoodmakerDishes> getAllByDishId(Integer dishId);

}

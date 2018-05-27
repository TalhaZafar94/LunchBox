package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Foodmaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FoodmakerRepository extends JpaRepository<Foodmaker , Integer> {

    Foodmaker findByFoodmakerEmail(String email);
    List<Foodmaker> findByFoodmakerName(String foodmakerName);
    Foodmaker getFoodmakerByFoodmakerCreatedAt(Date date);
    Foodmaker getFoodmakerByFoodmakerLastUpdated(Date date);

}

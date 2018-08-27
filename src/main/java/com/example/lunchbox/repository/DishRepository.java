package com.example.lunchbox.repository;

import com.example.lunchbox.model.entity.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dishes, Integer> {

}
